package com.prueba.vacuna.repository;

import com.prueba.vacuna.entity.VaccineStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface VaccineRepository extends JpaRepository<VaccineStatus, Long> {

    List<VaccineStatus> findByVaccinated(String vaccinated);

    @Query("FROM VaccineStatus t WHERE t.vaccineType.id = :id")
    List<VaccineStatus> findByVaccinatedType(Long id);

    @Query("FROM VaccineStatus t WHERE t.vaccineDate >= :fromDate and t.vaccineDate <= :toDate")
    List<VaccineStatus> getAllByVaccinatedDateRange(LocalDateTime fromDate, LocalDateTime toDate);
}
