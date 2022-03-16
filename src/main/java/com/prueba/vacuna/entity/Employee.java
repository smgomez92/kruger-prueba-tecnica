package com.prueba.vacuna.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "empleado")
@Entity
@Data
public class Employee {
    @Id
    @Column(name = "id_empleado", length = 10)
    private String identification;
    @Column(name = "nombre_empleado")
    private String name;
    @Column(name = "apellido_empleado")
    private String lastName;
    @Column(name = "email_empleado")
    private String email;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_additional_info")
    private AdditionalInfo additionalInfo;

    @OneToMany(mappedBy = "employee")
    private List<VaccineStatus> vaccineStatuses;
}
