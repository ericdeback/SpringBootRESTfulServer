package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {

    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>(){
            {
                add(new Student(1, "Mario", "Nothing"));
            }
        };
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void insertStudentToDb(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }


}
