package com.eps.Appointments.DTOs;

import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminDTO extends AbstractResponse{
    
    private String id;
    private String password;

}