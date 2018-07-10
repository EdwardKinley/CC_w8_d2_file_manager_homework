package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}
