package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import java.util.List;

public interface IUniversiteService {
    Universite add(Universite universite);
    List<Universite> addAll(List<Universite> universites);
    Universite update(Universite universite);
    List<Universite> updateAll(List<Universite> universites);
    void delete(Universite universite);
    void deleteById(Long id);
    void deleteAll();
    List<Universite> findAll();
    Universite findById(Long id);
    boolean existsById(Long id);
    Long count();
}
