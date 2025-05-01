package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IUniversiteService;
import com.example.oumayma_nfikha_tpfoyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService {
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public Universite add(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> addAll(List<Universite> universites) {
        return universiteRepository.saveAll(universites);
    }

    @Override
    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> updateAll(List<Universite> universites) {
        return universiteRepository.saveAll(universites);
    }

    @Override
    public void delete(Universite universite) {
        universiteRepository.delete(universite);
    }

    @Override
    public void deleteById(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        universiteRepository.deleteAll();
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findById(Long id) {
        return universiteRepository.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return universiteRepository.existsById(id);
    }

    @Override
    public Long count() {
        return universiteRepository.count();
    }
}
