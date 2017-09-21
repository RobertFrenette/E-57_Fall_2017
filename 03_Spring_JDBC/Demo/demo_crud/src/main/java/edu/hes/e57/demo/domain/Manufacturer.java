package edu.hes.e57.demo.domain;

import java.io.Serializable;

/**
 * This POJO defines a Manufacturer Object. 
 */
public class Manufacturer implements Serializable {
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return "Manufacturer - Id: " + id + ", Name: " + name;
    }    
}
