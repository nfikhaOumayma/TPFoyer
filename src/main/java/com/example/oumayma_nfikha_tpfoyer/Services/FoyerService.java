package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IFoyerService;
import com.example.oumayma_nfikha_tpfoyer.repositories.FoyerRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerService implements IFoyerService {

    @Autowired
    FoyerRepository foyerRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public Foyer add(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> addAll(List<Foyer> foyers) {
        return (List<Foyer>) foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer update(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> updateAll(List<Foyer> foyers) {
        return (List<Foyer>) foyerRepository.saveAll(foyers);
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public void deleteById(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        foyerRepository.deleteAll();
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer findById(Long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return foyerRepository.existsById(id);
    }

    @Override
    public Long count() {
        return foyerRepository.count();
    }

    @Override
    public void affecterFoyerUnivrsite(Long idFoyer , Long idUnivrsite) {
        Foyer f = foyerRepository.findById(idFoyer).get();
        Universite u = universiteRepository.findById(idUnivrsite).get();

        f.setUniversite(u);
        universiteRepository.save(u);
    }

    @Override
    public List<Foyer> findByBlocs_IdBloc(Long idBloc) {
        return foyerRepository.findByBlocs_IdBloc(idBloc);
    }

    @Override
    public Foyer findByIdFoyerAndBlocs_IdBloc(Long idFoyer, Long idBloc) {
        return foyerRepository.findByIdFoyerAndBlocs_IdBloc(idFoyer, idBloc);
    }

    @Override
    public List<Foyer> findByBlocs_IdBlocAndCapaciteFoyer(Long idBloc, Long capaciteFoyer) {
        return foyerRepository.findByBlocs_IdBlocAndCapaciteFoyer(idBloc, capaciteFoyer);
    }

    @Override
    public Foyer findByBlocs_IdBlocAndUniversite_IdUniversite(Long idBloc, Long idUniversite) {
        return foyerRepository.findByBlocs_IdBlocAndUniversite_IdUniversite(idBloc, idUniversite);
    }

    @Override
    public void desaffecterFoyerUniversite(Long idFoyer) {
        Foyer f = foyerRepository.findById(idFoyer).get();

        f.setUniversite(null);
        foyerRepository.save(f);
    }
}
