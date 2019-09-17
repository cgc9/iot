package com.udea.iotProject.controller;



import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.iotProject.model.Data;
import com.udea.iotProject.service.DataService;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
	
@RestController
@RequestMapping("/iot")
public class DataController {

    @Autowired
    private DataService dataService;

    @ApiOperation(value = "View a list of available devices", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    
    @GetMapping(path="/ver")
    public List<Data> getAllData() {
        return dataService.findAllDevices();
    	
    }
    
   /* @GetMapping(path="/verDate")
   		public List<Data> getAllDates() {
    	
        return dataService.findByDates();
    }
    
    @PostMapping("/{message}")
    public void sendMessage(@PathVariable String message) {
       dataService.sendMessage( message);
   	}*/
     
}
