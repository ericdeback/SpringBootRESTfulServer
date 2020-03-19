package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;

@Repository("MySQL")
public class MySQLDataAccessService implements PersonDao {

    @Autowired
    private JdbcTemplate JdbcTemplate;
    
    @Override
    public int insertPerson(Person person) {
        final String sql = "insert into Person (id, name) values (?, ?)";
        final String name = person.getName();
        String id="";

        try {
            id = person.getId().toString();
        } catch (Exception ex) {}
        if(id=="") {
            id = UUID.randomUUID().toString();
        }

        JdbcTemplate.update(sql, new Object[] {id, name});

        return 1;
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            person.setId(id);
            person.setName(name);

            return person;
        }
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "select id, name from Person";
        List<Person> persons = JdbcTemplate.query(sql, new PersonRowMapper());

        return persons;
    }



    @Override
    public List<Person> getPersonById(UUID id) {
        final String sql = "select id, name from Person where id = ?";

        List<Person> persons= new ArrayList<>();
        try {
            Person person = JdbcTemplate.queryForObject(sql, new PersonRowMapper(), id.toString());
            if (person != null) persons.add(person);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("no results found");
        }

        return persons;
    }

    @Override
    public int deletePersonById(UUID id) {
        final String sql = "delete from Person where id = ?";

        JdbcTemplate.update(sql, id.toString());

        return 1;
    }

    @Override
    public int updatePersonById(Person person) {
        //final String sql = "update Person set id= where id = \"" + id.toString()+"\"";

        final String sql = "update Person set name = ? where id = ?";
        final String name = person.getName();
        final String id = person.getId().toString(); //uuid.toString();

        JdbcTemplate.update(sql, new Object[] {name, id});

        return 1;
    }
}
