package edu.hes.e57.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * This POJO defines a Manufacturer Object.
 */
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer implements Serializable {
	private Long id;
	private int version;
	private String name;

	public Manufacturer() {}

	public Manufacturer(String name) {
		this.name = name;
	}

	public Manufacturer(Long id) {
		this.id = id;
	}

    @Id 
    @GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION") // optimistic locking
    public int getVersion() {
        return this.version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    @Column(name = "NAME")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return "Manufacturer - Id: " + id + ", Name: " + name;
    }    
}