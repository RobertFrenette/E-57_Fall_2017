package edu.hes.e57.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "AUTO")
public class Auto implements Serializable {
	private Long id;
	private int version;
    private String model;
    private String year;
    private String msrp;
    private byte[] photo;
     
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
    @Column(name = "VERSION") 
    public int getVersion() {
        return this.version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
	
    @NotEmpty(message="{validation.model.NotEmpty.message}")
    @Size(min=1, max=100, message="{validation.model.Size.message}")
	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

    @NotEmpty(message="{validation.year.NotEmpty.message}")
	@Column(name = "YEAR")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
    @NotEmpty(message="{validation.msrp.NotEmpty.message}")
	@Column(name = "MSRP")
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	
    // Photo
    @Basic(fetch= FetchType.LAZY)
    @Lob
    @Column(name = "PHOTO")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

	@Override
    public String toString() {
		return "Auto - Id: " + id + ", Model: " + model + ", Year: " + year + ", MSRP: $" + msrp;
    }
}
