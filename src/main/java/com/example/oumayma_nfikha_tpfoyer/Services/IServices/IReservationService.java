package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation add(Reservation reservation);
    List<Reservation> addAll(List<Reservation> reservations);
    Reservation update(Reservation reservation);
    List<Reservation> updateAll(List<Reservation> reservations);
    void delete(Reservation reservation);
    void deleteById(Long id);
    void deleteAll();
    List<Reservation> findAll();
    Reservation findById(Long id);
    boolean existsById(Long id);
    Long count();
    void affecterReservationAEtudiant(Long idR, String nomE, String prenomE);
    void desaffecterReservationAEtudiant(Long idR, String nomE, String prenomE);
    List<Reservation> getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee ) ;
    void annulerReservation(String cinEtudiant);

}
