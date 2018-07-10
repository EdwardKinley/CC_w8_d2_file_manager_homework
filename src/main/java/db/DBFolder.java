//package db;
//
//import models.File;
//import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class DBFolder {
//
//    private static Transaction transaction;
//    private static Session session;
//
//    public static List<File> getAllFiles() {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<File> results = null;
//        try {
//            Criteria cr = session.createCriteria(File.class);
//            results = cr.list();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }
//
//
//}
