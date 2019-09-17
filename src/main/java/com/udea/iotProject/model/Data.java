package com.udea.iotProject.model;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;
    
    private  Timestamp date;
	
    private Integer ruido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getRuido() {
		return ruido;
	}

	public void setRuido(Integer ruido) {
		this.ruido = ruido;
	}
   
  
	
    
    
}

