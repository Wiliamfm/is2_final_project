package com.eps.Appointments.DTOs;

import java.util.List;

import lombok.Data;

@Data
public class DoctorDTO {

    private String id;
    private HeadquarterDTO headquarterDTO;
    private List<SpecializationDTO> specializationDTOs;


}
