package com.example.oumayma_nfikha_tpfoyer.controllers;


import com.example.oumayma_nfikha_tpfoyer.Entite.Reservation;
import com.example.oumayma_nfikha_tpfoyer.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.add(reservation);
    }

    @PostMapping("/all")
    public List<Reservation> addAllReservation(@RequestBody List<Reservation> reservations) {
        return reservationService.addAll(reservations);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
       return reservationService.findById(id);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.update(reservation);
    }
    @PutMapping("/updateAll")
    public List<Reservation> updateAllReservations(@RequestBody List<Reservation> reservations) {
        return reservationService.updateAll(reservations);
    }

    @DeleteMapping
    public void deleteReservation(@RequestBody Reservation reservation) {
        reservationService.delete(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable Long id) {
        if (reservationService.existsById(id)) {
            reservationService.deleteById(id);
        }
    }

    @DeleteMapping("/all")
    public void deleteAllReservations() {
        reservationService.deleteAll();
    }

    @GetMapping("/exists/{id}")
    public Boolean existsById(@PathVariable Long id) {
        return  reservationService.existsById(id);
    }

    @GetMapping("/count")
    public Long countFoyers() {
        return reservationService.count();
    }

    @PutMapping("/{idR}/etudiant")
    public void affecterReservationAEtudiant(
            @PathVariable Long idR,
            @RequestParam String nomE,
            @RequestParam String prenomE) {

        reservationService.affecterReservationAEtudiant(idR, nomE, prenomE);
    }

    @DeleteMapping("/{idR}/etudiant")
    public void desaffecterReservationAEtudiant(
            @PathVariable Long idR,
            @RequestParam String nomE,
            @RequestParam String prenomE) {

        reservationService.desaffecterReservationAEtudiant(idR, nomE, prenomE);
    }

    @GetMapping("/{debutAnnee}/{finAnnee}")
    public List<Reservation> getReservationParAnneeUniversitaire(
            @PathVariable("debutAnnee") LocalDate debutAnnee,
            @PathVariable("finAnnee") LocalDate finAnnee) {

        return reservationService.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }

    @DeleteMapping("/annuler/{cinEtudiant}")
    public void annulerReservation(@PathVariable String cinEtudiant) {
            reservationService.annulerReservation(cinEtudiant);
    }
}