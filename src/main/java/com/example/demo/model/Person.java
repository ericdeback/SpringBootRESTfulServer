package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.*;
import java.util.*;

public class Person {
    private UUID id;
    @NotBlank
    private String name="";

    public Person(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
