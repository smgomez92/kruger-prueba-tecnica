package com.prueba.vacuna.mapper;

import com.prueba.vacuna.dto.EmployeeDto;
import com.prueba.vacuna.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    public Employee toEmployee(EmployeeDto employeeDto);

    public EmployeeDto toEmployeeDto(Employee employee);
}
