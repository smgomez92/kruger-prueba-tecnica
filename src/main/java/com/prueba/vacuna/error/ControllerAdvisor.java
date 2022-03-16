package com.prueba.vacuna.error;


import com.prueba.vacuna.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDto<String> handlerEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ResponseDto<String> response = new ResponseDto<>();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setData(ex.getMessage());
        return response;
    }
}
