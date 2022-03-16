package com.prueba.vacuna.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "estado_vacunacion")
@Entity
@Data
public class VaccineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_vacunacion")
    private LocalDateTime vaccineDate;
    @Column(name = "numero_dosis")
    private Integer dosisNumber;
    @Column(name = "vacunado", length = 2)
    private String vaccinated = "NO";

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "vacuna_id", nullable = false)
    private VaccineType vaccineType;

}
