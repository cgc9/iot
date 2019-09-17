package com.udea.iotProject.service;

import com.udea.iotProject.broker.IotSender;
import com.udea.iotProject.model.Data;
import com.udea.iotProject.model.Message;
import com.udea.iotProject.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class DataService {

    private DataRepository dataRepository;
    private IotSender iotSender;

    public DataService(IotSender iotSender, DataRepository dataRepository){
        this.dataRepository = dataRepository;
        this.iotSender= iotSender;
    }
    
    
    /* public void sendMessage(String message) {
    	
        StringBuilder sb = new StringBuilder();
        messages.forEach(message -> sb.append(message.getDeviceName()).append(",").append(message.getPayload()));
        iotSender.send("prueba", message.getBytes());
    }

    /*public List<Data>findByDates(Timestamp date1, Timestamp date2){
    
    	return dataRepository.findByDate(date1, date2);
     }*/
    
    public List<Data> findAllDevices(){
        return dataRepository.findAll();
    }
    
    public void processMessage(String message) {
    	//PASAR LA FECHA CON EL NIVEL DE RUIDO
    	Data dataModel = new Data();
    	Date date= new Date();
    	long time = date.getTime();
    	Timestamp timeSt = new Timestamp(time);
		dataModel.setDate(timeSt);
		System.out.println("FECHA:"+dataModel.getDate());
		Integer ruido =Integer.parseInt(message);
		dataModel.setRuido(ruido);
		System.out.println("RUIDO:	"+dataModel.getRuido());
		//2019-09-01 12:00:19.77
		dataRepository.save(dataModel);
    }
}
