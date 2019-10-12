package com.udea.iotProject.service;

import com.udea.iotProject.broker.IotSender;
import com.udea.iotProject.model.Data;
import com.udea.iotProject.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DataService {

    private DataRepository dataRepository;
    private IotSender iotSender;

    public DataService(IotSender iotSender, DataRepository dataRepository){
        this.dataRepository = dataRepository;
        this.iotSender= iotSender;
    }
    
    
    public void sendMessage(String message) {
        iotSender.send("iot", message.getBytes());
    }
    
    public List<Data> findAllDevices(){
        return dataRepository.findAll();
    }
    
    
    public List<Data> findByDate(String dateIn, String dateE){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	LocalDateTime date1 = LocalDateTime.parse(dateIn, formatter);
    	LocalDateTime date2 = LocalDateTime.parse(dateE, formatter);
        return dataRepository.findByDateBetween(date1, date2);   
    }
    
    public List<Data> findByDateNoise(String dateIn, String dateE){
    	int noise=1000;
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	LocalDateTime date1 = LocalDateTime.parse(dateIn, formatter);
    	LocalDateTime date2 = LocalDateTime.parse(dateE, formatter);
        return dataRepository.findByDateBetweenAndNoiseLevelGreaterThan(date1, date2, noise);   
    }
    
    public List<Data> findByLevel(){
    	String lev="c";
        return dataRepository.findByNoiseSignal(lev);   
    }
    
   
    public void processMessage(String message) {
    	
    	if(message.startsWith("c")) {
    		String[] parts = message.split("c");
    		Data dataModel = new Data();
        	LocalDateTime date= LocalDateTime.now();
        	dataModel.setDate(date);
    		System.out.println("FECHA:"+dataModel.getDate());
    		Integer noiseLevel =Integer.parseInt(parts[1]);
    		dataModel.setNoiseLevel(noiseLevel);
    		dataModel.setNoiseSignal("c");
    		System.out.println("RUIDO:"+dataModel.getNoiseLevel()+"\n");	
    		//System.out.println("\n");
    		dataRepository.save(dataModel);
    		
    	}else {
    	
    	Data dataModel = new Data();
    	LocalDateTime date= LocalDateTime.now();
    	dataModel.setDate(date);
		System.out.println("FECHA:"+dataModel.getDate());
		Integer noiseLevel =Integer.parseInt(message);
		dataModel.setNoiseLevel(noiseLevel);
		dataModel.setNoiseSignal("");
		System.out.println("RUIDO:"+dataModel.getNoiseLevel()+"\n");
		//System.out.println("\n");
		dataRepository.save(dataModel);
		}
    }
}
