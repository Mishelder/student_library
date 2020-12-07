package by.misha.dao;

import by.misha.entity.Student;

public interface StudentDao extends CrudDao<Student> {
    Integer getCountRow();
}
