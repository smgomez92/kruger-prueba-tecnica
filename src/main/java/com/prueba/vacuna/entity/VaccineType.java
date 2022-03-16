package com.prueba.vacuna.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tipo_vacuna")
@Entity
@Data
public class VaccineType {
    @Id
    @Column(name = "vacuna_id")
    private Long id;
    @Column(name = "nombre_vacuna")
    private String name;
}
