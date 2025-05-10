package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IReservationService;
import com.example.oumayma_nfikha_tpfoyer.repositories.ChambreRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.EtudiantRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    ChambreRepository chambreRepository;

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

        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Etudiant not found");
        }

        List<Reservation> reservations = reservationRepository.findByEtudiantCin(cinEtudiant);

        for (Reservation reservation : reservations) {
            reservation.getEtudiants().remove(etudiant);

            reservationRepository.save(reservation);
        }
    }


    @Override
    public Reservation ajouterReservationETAssignerAChambreEtAEtudiant(Long numChambre, String cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new EntityNotFoundException("Etudiant not found with cin: " + cinEtudiant);
        }

        Chambre chambre = chambreRepository.findByNumeroChambre(numChambre);
        if (chambre == null) {
            throw new EntityNotFoundException("Chambre not found with number: " + numChambre);
        }

        Reservation reservation = Reservation.builder()
                .anneUniversitaire(LocalDate.now())
                .estValide(true)
                .etudiants(new HashSet<>())
                .build();

        reservation.getEtudiants().add(etudiant);
        chambre.getReservations().add(reservation);

        reservationRepository.save(reservation);
        chambreRepository.save(chambre);
        return reservation;
    }

}
