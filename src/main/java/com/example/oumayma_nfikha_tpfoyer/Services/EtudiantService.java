package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IEtudiantService;
import com.example.oumayma_nfikha_tpfoyer.repositories.EtudiantRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EtudiantService implements IEtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Etudiant add(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> addAll(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> updateAll(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public void delete(Etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }

    @Override
    public void deleteById(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        etudiantRepository.deleteAll();
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(Long id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return etudiantRepository.existsById(id);
    }

    @Override
    public Long count() {
        return etudiantRepository.count();
    }



    

}
