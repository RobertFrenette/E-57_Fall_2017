package edu.hes.e57.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;

/**
 * This POJO defines a Auto Object.
 */
@Entity
@Table(name = "AUTO")
public class Auto implements Serializable {
	private Long id;
	private int version;
    private String model;
    private String year;
    private String msrp;
    private Manufacturer manufacturer;
    private Set<Drivetrain> drivetrains = new HashSet<Drivetrain>();
         
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
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

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID")
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    @ManyToMany
    @JoinTable(name = "DRIVETRAIN_AUTO", 
        joinColumns = @JoinColumn(name = "AUTO_ID"), 
        inverseJoinColumns = @JoinColumn(name = "DRIVETRAIN_ID"))
    public Set<Drivetrain> getDrivetrains() {
        return this.drivetrains;
    }
    public void setDrivetrains(Set<Drivetrain> drivetrains) {
        this.drivetrains = drivetrains;
    }
    public void addDrivetrain(Drivetrain drivetrain) {
    	getDrivetrains().add(drivetrain);
}
	
	@Override
    public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Auto Id: ");
		str.append(id);
		str.append(", Manufacturer ID: ");
		str.append(getManufacturer().getId());
		str.append(", Model: ");
		str.append(model);
		str.append(", Year: ");
		str.append(year);
		str.append(", MSRP: $");
		str.append(msrp);
		str.append(".");
		return str.toString();
    }
}
