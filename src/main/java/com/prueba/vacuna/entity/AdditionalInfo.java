package com.prueba.vacuna.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "informacion_adicional")
@Entity
@Data
public class AdditionalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "celular")
    private String cellPhone;
    @Column(name = "direccion")
    private String address;
    @Column(name = "fecha_nacimiento")
    private LocalDateTime birthDate;

    @OneToOne(mappedBy = "additionalInfo")
    private Employee employee;


}
