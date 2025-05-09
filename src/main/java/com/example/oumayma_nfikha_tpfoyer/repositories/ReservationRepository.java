package com.example.oumayma_nfikha_tpfoyer.repositories;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.anneUniversitaire >= :debutAnnee AND r.anneUniversitaire <= :finAnnee")
    List<Reservation> findByAnneUniversitaireBetween(@Param("debutAnnee") LocalDate debutAnnee, @Param("finAnnee") LocalDate finAnnee);

    @Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.cin = :cinEtudiant")
    List<Reservation> findByEtudiantCin(@Param("cinEtudiant") String cinEtudiant);

}
