package com.example.demo.dao;

import com.example.demo.model.*;

import java.util.*;

public interface PersonDao {

    int insertPerson(Person person);

    List<Person> selectAllPeople();

    List<Person> getPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(Person person);

}
