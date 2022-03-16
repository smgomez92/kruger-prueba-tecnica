package com.prueba.vacuna.controller;

import com.prueba.vacuna.dto.EmployeeDto;
import com.prueba.vacuna.dto.ResponseDto;
import com.prueba.vacuna.dto.VaccineStatusDto;
import com.prueba.vacuna.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping("/")
    public ResponseEntity<ResponseDto<List<EmployeeDto>>> getAllEmployees() {
        ResponseDto<List<EmployeeDto>> response = new ResponseDto<>();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(service.getAllEmployees());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<EmployeeDto>> getEmployeeById(@PathVariable String id) {
        ResponseDto<EmployeeDto> response = new ResponseDto<>();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(service.getEmployeeById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEmployee(employeeDto));
    }

    @PutMapping("/vaccineStatus")
    public ResponseEntity<VaccineStatusDto> updateVaccineStatus(@RequestBody VaccineStatusDto vaccineStatusDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateVaccineStatus(vaccineStatusDto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto<String>> deleteEmployee(@PathVariable String id) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        service.deleteEmployee(id);

        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setStatus(HttpStatus.OK.getReasonPhrase());
        responseDto.setData(String.format("Employee with id %s was deleted", id));
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);

    }

    @GetMapping("/status")
    public ResponseEntity<ResponseDto<List<VaccineStatusDto>>> getAllByVaccineStatus(
            @RequestParam(required = false, defaultValue = "NO") String status) {
        ResponseDto<List<VaccineStatusDto>> response = new ResponseDto<>();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(service.getByVaccineStatus(status.toUpperCase()));
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/type")
    public ResponseEntity<ResponseDto<List<VaccineStatusDto>>> getAllByVaccineType(
            @RequestParam(required = false, defaultValue = "0") Long type) {
        ResponseDto<List<VaccineStatusDto>> response = new ResponseDto<>();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(service.getByVaccineType(type));
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/range")
    public ResponseEntity<ResponseDto<List<VaccineStatusDto>>> getAllByVaccineRangeDate(
            @RequestParam(required = false, defaultValue = "12-12-1900") String fromDate,
            @RequestParam(required = false, defaultValue = "12-12-2999") String toDate) {
        ResponseDto<List<VaccineStatusDto>> response = new ResponseDto<>();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(service.getByVaccineDateRange(fromDate, toDate));
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
