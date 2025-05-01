package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IChambreService;
import com.example.oumayma_nfikha_tpfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChambreService implements IChambreService {

    @Autowired
    ChambreRepository chambreRepository;

    @Override
    public Chambre add(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> addAll(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> updateAll(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public void delete(Chambre chambre) {
        chambreRepository.delete(chambre);
    }

    @Override
    public void deleteById(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        chambreRepository.deleteAll();
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findById(Long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return chambreRepository.existsById(id);
    }

    @Override
    public Long count() {
        return chambreRepository.count();
    }

    @Override
    public Chambre findByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Override
    public List<Chambre> findByTypeC(TypeChambre typeC) {
        return chambreRepository.findByTypeC(typeC);
    }

    @Override
    public List<Chambre> findByBloc_IdBloc(Long idBloc) {
        return chambreRepository.findByBloc_IdBloc(idBloc);
    }

    @Override
    public List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBloc_IdBlocAndTypeC(idBloc, typeC);
    }

    @Override
    public Chambre findByNumeroChambreAndTypeC(Long numeroChambre, TypeChambre typeC) {
        return chambreRepository.findByNumeroChambreAndTypeC(numeroChambre, typeC);
    }

    @Override
    public List<Chambre> findByBloc_Foyer_NomFoyerAndReservations_AnneUniversitaireAndReservations_Etudiants_NomEt(String nomFoyer, LocalDate anneUniversitaire, String nomEtudiant) {
        return chambreRepository.findByBloc_Foyer_NomFoyerAndReservations_AnneUniversitaireAndReservations_Etudiants_NomEt(nomFoyer, anneUniversitaire, nomEtudiant);
    }

    @Override
    public Long countByTypeCAndBloc_Foyer_NomFoyer(TypeChambre typeC, String nomFoyer) {
        return chambreRepository.countByTypeCAndBloc_Foyer_NomFoyer(typeC, nomFoyer);
    }
}
