package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("inMemDao") // @Repository makes this class a Bean that can be injected into other classes
public class inMemoryDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(Person person){
        // this method was added to implement the interface but I'm not sure what is the difference between insertPerson(Person) abd insertPerson(UUID, Person)

        return 0;
    }

    public int insertPerson(UUID id, Person person) {
        System.out.println("Called: insertPerson()");
        DB.add(new Person(id, person.getName()));

        System.out.println(person.getName() + " created");
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        System.out.println("Called: selectAllPeople()");
        for (Person person: DB) {
            System.out.println(person.getId());
            System.out.println(person.getName());
        }
        return DB;
    }

    @Override
    public List<Person> getPersonById(UUID id) {
        System.out.println("Called: selectPersonById()");
/*        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();*/
          return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        List<Person> found = new ArrayList<>();

        System.out.println("Called: deletePersonById()");
        for (Person person: DB) {
            if (person.getId().equals(id)) found.add(person);

            System.out.println("removed: " + person.getId());
        }
        DB.removeAll(found);
        return 1;
    }

    @Override
    public int updatePersonById(Person person) {
        System.out.println("Called: updatePersonById()");

        for (Person person_: DB) {
            if (person_.getId().equals(person.getId())) {
                DB.remove(person_);
                person.setId(person.getId());
                DB.add(person);
                System.out.println("updated: " + person.getId());
                return 1;
            }
        }
        System.out.println("updated nothing");
        return 0;
    }
}
