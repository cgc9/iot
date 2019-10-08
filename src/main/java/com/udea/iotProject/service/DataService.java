package com.udea.iotProject.service;

import com.udea.iotProject.broker.IotSender;
import com.udea.iotProject.model.Data;
import com.udea.iotProject.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    
    public List<Data> findByDate(LocalDateTime date1, LocalDateTime date2){
        return dataRepository.findByDateBetween(date1, date2);   
    }
    
    public List<Data> findByDateNoise(LocalDateTime date1, LocalDateTime date2){
    	int noise=40;
        return dataRepository.findByDateBetweenAndRuidoGreaterThan(date1, date2, noise);   
    }
    
    public void processMessage(String message) {
    	Data dataModel = new Data();
    	LocalDateTime date= LocalDateTime.now();
    	dataModel.setDate(date);
		System.out.println("FECHA:"+dataModel.getDate());
		Integer noiseLevel =Integer.parseInt(message);
		dataModel.setRuido(noiseLevel);
		System.out.println("RUIDO:"+dataModel.getRuido());	
		dataRepository.save(dataModel);
    }
}
