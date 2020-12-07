package by.misha.dao;

import by.misha.entity.Book;

import java.util.List;

public interface BookDao extends CrudDao<Book> {

    List<Book> findAllBooksStudent(Integer idStudent);
}
