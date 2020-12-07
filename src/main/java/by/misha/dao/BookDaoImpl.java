package by.misha.dao;

import by.misha.entity.Book;
import by.misha.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BookDaoImpl implements BookDao{

    private final  HibernateUtil hibernateUtil = HibernateUtil.create();

    public List<Book> findAllBooksStudent(Integer idStudent) {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        List<Book> list =(List<Book>) session.createQuery("from Book where student = "+ idStudent).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Book find(Integer id) {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        Book book = session.get(Book.class,id);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public void save(Book model) {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Book model) {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer id) {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        Book book = find(id);
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> findAll() {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        List<Book> books = session.createQuery("from Book").getResultList();
        session.getTransaction().commit();
        session.close();
        return books;
    }
}
