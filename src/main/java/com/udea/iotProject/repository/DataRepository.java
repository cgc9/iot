package com.udea.iotProject.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udea.iotProject.model.Data;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DataRepository extends JpaRepository<Data,Integer> {
	
	/*@Query("select * from data  where date between '2019-09-08 23:22:02' and '2019-09-08 23:25:35'")
	 List<Data>findByDate();
	 List<Data>findByDate(Timestamp date1, Timestamp date2);*/	

}
