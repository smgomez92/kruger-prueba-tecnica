package com.prueba.vacuna.mapper;

import com.prueba.vacuna.dto.VaccineStatusDto;
import com.prueba.vacuna.entity.VaccineStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VaccineMapper {
    VaccineStatusDto toVaccineStatusDto(VaccineStatus vaccineStatus);

    VaccineStatus toVaccineStatus(VaccineStatusDto vaccineDto);
}
