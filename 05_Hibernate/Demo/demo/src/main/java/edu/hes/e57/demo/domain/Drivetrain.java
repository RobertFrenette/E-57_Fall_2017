package edu.hes.e57.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This POJO defines a Drivetrain Object. 
 */
@Entity
@Table(name = "DRIVETRAIN")
public class Drivetrain implements Serializable {
	private Long id;
    private String transmission;
    private String engine_displacement;
    
    public Drivetrain() {};
    public Drivetrain(String transmission, String engine_displacement) {
    		this.transmission = transmission;
    		this.engine_displacement = engine_displacement;
    }
    public Drivetrain(Long id) {
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
	
	@Column(name = "TRANSMISSION")
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	@Column(name = "ENGINE_DISPLACEMENT")
	public String getEngineDisplacement() {
		return engine_displacement;
	}
	public void setEngineDisplacement(String engine_displacement) {
		this.engine_displacement = engine_displacement;
	}
	    
	@Override
    public String toString() {
        return "Drivetrain - Id: " + id + ", Transmission: " + transmission + ", EngineDisplacement: " + engine_displacement;
    }
}