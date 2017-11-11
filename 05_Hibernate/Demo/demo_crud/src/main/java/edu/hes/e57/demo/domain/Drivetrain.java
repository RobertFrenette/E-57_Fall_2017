package edu.hes.e57.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private Set<Auto> autos = new HashSet<Auto>();
        
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
	
    @ManyToMany
    @JoinTable(name = "DRIVETRAIN_AUTO", 
        joinColumns = @JoinColumn(name = "DRIVETRAIN_ID"), 
        inverseJoinColumns = @JoinColumn(name = "AUTO_ID"))
    public Set<Auto> getAutos() {
        return this.autos;
    }
    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }
    
	@Override
    public String toString() {
        return "Drivetrain - Id: " + id + ", Transmission: " + transmission + ", EngineDisplacement: " + engine_displacement;
    }
}