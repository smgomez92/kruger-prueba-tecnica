package com.prueba.vacuna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineStatusDto {
    private Long id;
    private LocalDateTime vaccineDate;
    private Integer dosisNumber;
    private String vaccinated;
    private EmployeeDto employee;
    private VaccineTypeDto vaccineType;
}
