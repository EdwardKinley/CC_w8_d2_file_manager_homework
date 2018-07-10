import db.DBFile;
import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("Photos");
        Folder folder2 = new Folder("Bank statements");
        File file1 = new File("holiday photo", "jpg", 3000, folder1);
        File file2 = new File("passport photo", "jpg", 500, folder1);
        File file3 = new File("graduation photo", "jpg", 4500, folder1);
        File file4 = new File("wedding photo", "jpg", 6000, folder1);
        File file5 = new File("March 2018", "pdf", 600, folder2);
        File file6 = new File("April 2018", "pdf", 600, folder2);
        File file7 = new File("May 2018", "pdf", 600, folder2);
        File file8 = new File("June 2018", "pdf", 600, folder2);

        DBHelper.save(folder1);
        DBHelper.save(folder2);
        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);
        DBHelper.save(file4);
        DBHelper.save(file5);
        DBHelper.save(file6);
        DBHelper.save(file7);
        DBHelper.save(file8);

        System.out.println(DBHelper.getAll(File.class));
        System.out.println(DBHelper.getAll(Folder.class));

        file4.setname("our wedding photo");
        DBHelper.update(file4);
        folder2.setTitle("bank statements etc");
        DBHelper.update(folder2);
        file3.setSize(4600);
        DBHelper.update(file3);

//        DBHelper.delete(file8);
//        DBHelper.delete(file7);
//        DBHelper.delete(file6);
//        DBHelper.delete(file5);
//        DBHelper.delete(folder2);

        File file1byid = DBHelper.findById(File.class, 1);
        Folder folder2byid = DBHelper.findById(Folder.class, 2);

        List<File> filesbysize = DBFile.findBySize(2000, 5000);

        List<File> folder1files = DBFile.getAllFilesInFolder(folder1);
        List<File> folder2files = DBFile.getAllFilesInFolder(folder2);

        int intg = 0;

        System.exit(0);
    }

}

