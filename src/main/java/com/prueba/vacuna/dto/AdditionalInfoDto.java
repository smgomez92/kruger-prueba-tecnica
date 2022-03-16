package com.prueba.vacuna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.prueba.vacuna.entity.Employee;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalInfoDto {

    private Long id;
    private String cellPhone;
    private String address;
    private LocalDateTime birthDate;

}
