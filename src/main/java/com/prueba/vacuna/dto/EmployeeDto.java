package com.prueba.vacuna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.vacuna.entity.VaccineStatus;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    //@JsonProperty()
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private AdditionalInfoDto additionalInfo;
}
