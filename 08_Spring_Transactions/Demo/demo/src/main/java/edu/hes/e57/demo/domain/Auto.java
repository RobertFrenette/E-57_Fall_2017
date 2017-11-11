package edu.hes.e57.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * This POJO defines a Auto Object.
 */
@Entity
@Table(name = "AUTO")
@NamedQueries({
    @NamedQuery(name="Contact.findAll", query="select a from Auto a"),
    @NamedQuery(name="Contact.countAll", query="select count(a) from Auto a")
})
public class Auto implements Serializable {
	private Long id;
	private int version;
    private String model;
    private String year;
    private String msrp;
     
	public Auto() {}
	public Auto(String model_name, String year, String msrp) {
		this.model = model;
		this.year = year;
		this.msrp = msrp;
	}
	public Auto(Long id) {
		this.id = id;
	}
    
    @Id 
    @GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
    public Long getId() {
		return id;
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
	
	@Column(name = "MODEL")
	public String getModelName() {
		return model;
	}
	public void setModelName(String model) {
		this.model = model;
	}
	
	@Column(name = "YEAR")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Column(name = "MSRP")
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}

	
	@Override
    public String toString() {
        return "Auto - Id: " + id + ", Model: " + model + ", Year: " + year + ", MSRP: $" + msrp;
    }
}
