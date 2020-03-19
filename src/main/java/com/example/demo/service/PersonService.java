package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("MySQL") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public List<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public int updatePerson(Person person) {
        return personDao.updatePersonById(person);
    }

}
