package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;

import java.util.List;

public interface IFoyerService {
    Foyer add(Foyer foyer);

    List<Foyer> addAll(List<Foyer> foyers);

    Foyer update(Foyer foyer);

    List<Foyer> updateAll(List<Foyer> foyers);

    void delete(Foyer foyer);

    void deleteById(Long id);

    void deleteAll();

    List<Foyer> findAll();

    Foyer findById(Long id);

    boolean existsById(Long id);

    Long count();

    void affecterFoyerUnivrsite(Long idFoyer, Long idUnivrsi);

    List<Foyer> findByBlocs_IdBloc(Long idBloc);

    Foyer findByIdFoyerAndBlocs_IdBloc(Long idFoyer, Long idBloc);

    List<Foyer> findByBlocs_IdBlocAndCapaciteFoyer(Long idBloc, Long capaciteFoyer);

    Foyer findByBlocs_IdBlocAndUniversite_IdUniversite(Long idBloc, Long idUniversite);

     void desaffecterFoyerUniversite(Long idFoyer);
}
