package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant add(Etudiant etudiant);
    List<Etudiant> addAll(List<Etudiant> etudiants);
    Etudiant update(Etudiant etudiant);
    List<Etudiant> updateAll(List<Etudiant> etudiants);
    void delete(Etudiant etudiant);
    void deleteById(Long id);
    void deleteAll();
    List<Etudiant> findAll();
    Etudiant findById(Long id);
    boolean existsById(Long id);
    Long count();
}
