package by.misha.dao;

import by.misha.entity.Student;
import by.misha.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final HibernateUtil hibernateUtil = HibernateUtil.create();

    public Integer getCountRow() {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        Integer count = session.createQuery("from Student").getResultList().size();
        session.getTransaction().commit();
        session.close();
        return count;
    }

    public Student find(Integer id) {
        if(id==null)
            throw new IllegalArgumentException("id Student is null");
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        Student temp = session.get(Student.class,id);
        session.getTransaction().commit();
        session.close();
        return temp;
    }

    public void save(Student model) {
        if(model==null)
            throw new IllegalArgumentException("model is null");
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Student model) {
        if(model==null)
            throw new IllegalArgumentException("model is null");
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer id) {
        if(id==null)
            throw new IllegalArgumentException("model is null");
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        Student student = find(id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

    public List<Student> findAll() {
        Session session = hibernateUtil.getSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("FROM Student s ORDER BY s.name,s.group").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }
}
