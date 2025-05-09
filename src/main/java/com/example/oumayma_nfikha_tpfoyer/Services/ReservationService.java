package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IReservationService;
import com.example.oumayma_nfikha_tpfoyer.repositories.EtudiantRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> addAll(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> updateAll(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        reservationRepository.deleteAll();
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return reservationRepository.existsById(id);
    }

    @Override
    public Long count() {
        return reservationRepository.count();
    }

    @Override
    public void affecterReservationAEtudiant(Long idR, String nomE, String prenomE) {
        Reservation res =  reservationRepository.findById(idR).get();
        Etudiant et = etudiantRepository.findByNomEtAndPrenomEt(nomE , prenomE);

        et.getReservations().add(res);
        etudiantRepository.save(et);
    }

    @Override
    public void desaffecterReservationAEtudiant(Long idR, String nomE, String prenomE) {
        Reservation res =  reservationRepository.findById(idR).get();
        Etudiant et = etudiantRepository.findByNomEtAndPrenomEt(nomE , prenomE);

        et.getReservations().remove(res);
        etudiantRepository.save(et);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee) {
        return reservationRepository.findByAnneUniversitaireBetween(debutAnnee, finAnnee);
    }

    @Override
    public void annulerReservation(String cinEtudiant) {

        // Find the student by CIN
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Etudiant not found");
        }

        // Find all reservations for the student
        List<Reservation> reservations = reservationRepository.findByEtudiantCin(cinEtudiant);

        for (Reservation reservation : reservations) {
            // Remove the student from the reservation
            reservation.getEtudiants().remove(etudiant);

            // Save the updated reservation
            reservationRepository.save(reservation);
        }
    }

}
