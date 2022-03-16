package com.prueba.vacuna.repository;

import com.prueba.vacuna.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
