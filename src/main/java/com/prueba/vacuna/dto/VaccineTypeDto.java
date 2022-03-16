package com.prueba.vacuna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineTypeDto {
    private Long id;
    private String name;
}
