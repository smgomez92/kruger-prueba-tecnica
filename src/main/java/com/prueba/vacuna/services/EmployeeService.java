package com.prueba.vacuna.services;

import com.prueba.vacuna.dto.EmployeeDto;
import com.prueba.vacuna.dto.VaccineStatusDto;
import com.prueba.vacuna.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto getEmployeeById(String ide);

    public List<EmployeeDto> getAllEmployees();

    public EmployeeDto updateEmployee(EmployeeDto employeeDto);

    public Boolean deleteEmployee(String id);

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public VaccineStatusDto updateVaccineStatus(VaccineStatusDto vaccineStatusDto);

    public List<VaccineStatusDto> getByVaccineStatus(String status);

    public List<VaccineStatusDto> getByVaccineType(Long type);

    public List<VaccineStatusDto> getByVaccineDateRange(String fromDate, String toDate);

}
