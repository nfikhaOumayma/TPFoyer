package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
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
}
