package edu.hes.e57.demo.domain;

import java.io.Serializable;

/**
 * This POJO defines a Auto Object. 
 */
public class Auto implements Serializable {
	private Long id;
	private Long manufacturerId;
	private String model;
	private String year;
	private String msrp;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getManufacturerId() {
		return manufacturerId;
	}
	
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMsrp() {
		return msrp;
	}
	
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	
	@Override
    public String toString() {
        return "Auto - Id: " + id + ", ManufacturerId: " + manufacturerId + ", Model: " + model + ", Year: " + year + ", Msrp: $" + msrp;
    }
}