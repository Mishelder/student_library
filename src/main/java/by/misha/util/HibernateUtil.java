package by.misha.util;

import by.misha.entity.Book;
import by.misha.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateUtil {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static HibernateUtil hibernateUtil;
    private HibernateUtil(){}

    public static HibernateUtil create(){
        if(hibernateUtil==null) {
            hibernateUtil = new HibernateUtil();
            configuration = new Configuration()
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Student.class)
                    .configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return hibernateUtil;
    }

    public Session getSession(){
       return sessionFactory.openSession();
    }

}
