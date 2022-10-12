package com.eps.Appointments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DateService;

@RestController
@RequestMapping("/dates")
@CrossOrigin
public class DateController {

    @Autowired
    private DateService dateService;

    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody DateDTO dateDTO){
        try{
            DateDTO newDate= dateService.create(dateDTO);
            if(newDate != null){
                return new ResponseEntity<>(newDate, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new ErrorDTO("Date not created"), HttpStatus.ACCEPTED);
        } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping()
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<>(dateService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
