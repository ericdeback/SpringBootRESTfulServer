package com.example.demo.api;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.lang.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.validation.*;
import java.util.*;

//@RequestMapping(path = "api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    //@PostMapping
    @RequestMapping(value = "/api/v1/person", method = RequestMethod.POST)
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    // @GetMapping
    @RequestMapping(value = "/api/v1/person", method = RequestMethod.GET)
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    //@DeleteMapping(path = "{id}")
    @RequestMapping(value = "/api/v1/person/{id}", method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }

    //@GetMapping(path = "{id}")
    @RequestMapping(value = "/api/v1/person/{id}", method = RequestMethod.GET)
    List<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }

    //@PutMapping
    @RequestMapping(value = "/api/v1/person", method = RequestMethod.PUT)
    public void updatePerson(@Valid @NonNull @RequestBody Person person) {
        personService.updatePerson(person);
    }


    @RequestMapping(value = "/api/v1/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> login() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(null);
        responseHeaders.set("MyHeaderKey", "MyValue");
        responseHeaders.add("Set-Cookie","sessionid=123edb2020; Domain=localhost; Path=/; Expires=foo; HttpOnly; Secure");

        return new ResponseEntity<String>("Test Function: login()", responseHeaders, HttpStatus.OK);

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<String> any() {

        // 1. Collect the incoming headers and extract UID/password
        // 2. Validate UID/password
        // 3. is validated return sessionid
        // 4. Maintain a list of valid sessions and check in all restful methods if incoming requests have a valid sessionid

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(null);
        responseHeaders.set("MyHeaderKey", "MyValue");
        responseHeaders.add("Set-Cookie","sessionid=123edb2020; Domain=localhost; Path=/; Expires=foo; HttpOnly; Secure");

        HttpSession session = new HttpSession() {
            @Override
            public long getCreationTime() {
                return 0;
            }

            @Override
            public String getId() {
                return null;
            }

            @Override
            public long getLastAccessedTime() {
                return 0;
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public void setMaxInactiveInterval(int i) {

            }

            @Override
            public int getMaxInactiveInterval() {
                return 0;
            }

            @Override
            public HttpSessionContext getSessionContext() {
                return null;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Object getValue(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public String[] getValueNames() {
                return new String[0];
            }

            @Override
            public void setAttribute(String s, Object o) {

            }

            @Override
            public void putValue(String s, Object o) {

            }

            @Override
            public void removeAttribute(String s) {

            }

            @Override
            public void removeValue(String s) {

            }

            @Override
            public void invalidate() {

            }

            @Override
            public boolean isNew() {
                return false;
            }
        };

        return new ResponseEntity<String>("Test Function: login()", responseHeaders, HttpStatus.OK);

    }


}
