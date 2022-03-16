package com.prueba.vacuna.services;

import com.prueba.vacuna.dto.EmployeeDto;
import com.prueba.vacuna.dto.VaccineStatusDto;
import com.prueba.vacuna.entity.Employee;
import com.prueba.vacuna.error.EmployeeNotFoundException;
import com.prueba.vacuna.mapper.EmployeeMapper;
import com.prueba.vacuna.mapper.VaccineMapper;
import com.prueba.vacuna.repository.EmployeeRepository;
import com.prueba.vacuna.repository.VaccineRepository;
import com.prueba.vacuna.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    @Override
    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeById(String ide) {
        log.info("Get Employee whit id {}", ide);
        Employee employee = employeeRepository.findById(ide)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(String.format("Employee with id %s not found", ide)));
        return employeeMapper.toEmployeeDto(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees() {
        log.info("Getting all employees");
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getIdentification() != null) {
            employeeDto = this.saveEmployee(employeeDto);
        }
        return employeeDto;
    }

    @Override
    @Transactional
    public Boolean deleteEmployee(String id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(String.format("Employee with id %s not found", id)));
        if (employee != null) {
            if (!employee.getVaccineStatuses().isEmpty()) {
                employee.getVaccineStatuses().forEach(vaccineRepository::delete);
            }
            employeeRepository.delete(employee);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    @Transactional
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.toEmployee(employeeDto));
        return employeeDto;
    }

    @Override
    @Transactional
    public VaccineStatusDto updateVaccineStatus(VaccineStatusDto vaccineStatusDto) {
        Long id = vaccineRepository.save(vaccineMapper.toVaccineStatus(vaccineStatusDto)).getId();
        vaccineStatusDto.setId(id);
        return vaccineStatusDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VaccineStatusDto> getByVaccineStatus(String status) {
        return vaccineRepository.findByVaccinated(status)
                .stream()
                .map(vaccineMapper::toVaccineStatusDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VaccineStatusDto> getByVaccineType(Long type) {
        return vaccineRepository.findByVaccinatedType(type)
                .stream()
                .map(vaccineMapper::toVaccineStatusDto).collect(Collectors.toList());
    }

    @Override
    public List<VaccineStatusDto> getByVaccineDateRange(String fromDate, String toDate) {
        final String FORMAT_DATE = "dd-MM-yyyy";

        return vaccineRepository
                .getAllByVaccinatedDateRange(Utils.toLocalDateTime(fromDate, FORMAT_DATE), Utils.toLocalDateTime(toDate, FORMAT_DATE))
                .stream()
                .map(vaccineMapper::toVaccineStatusDto).collect(Collectors.toList());
    }
}
