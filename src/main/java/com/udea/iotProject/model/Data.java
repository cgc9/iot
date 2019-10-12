package com.udea.iotProject.model;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;
    
    private  LocalDateTime date;
	
    private Integer noiseLevel;
    
    private String noiseSignal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getNoiseLevel() {
		return noiseLevel;
	}

	public void setNoiseLevel(Integer noiseLevel) {
		this.noiseLevel = noiseLevel;					
	}

	public String getNoiseSignal() {
		return noiseSignal;
	}

	public void setNoiseSignal(String noiseSignal) {
		this.noiseSignal = noiseSignal;
	}
      
}

