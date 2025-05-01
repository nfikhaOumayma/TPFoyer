package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.Bloc;
import com.example.oumayma_nfikha_tpfoyer.Entite.Foyer;

import java.util.List;

public interface IBlocService {

    Bloc add(Bloc bloc);

    List<Bloc> addAll(List<Bloc> blocs);

    Bloc update(Bloc bloc);

    List<Bloc> updateAll(List<Bloc> blocs);

    void delete(Bloc bloc);

    void deleteById(Long id);

    void deleteAll();

    List<Bloc> findAll();

    Bloc findById(Long id);

    boolean existsById(Long id);

    Long count();

    List<Bloc> findByBlocName(String blocName);

    List<Bloc> findByCapacity(Long capacity);

    List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, Long capaciteBloc);

    List<Bloc> findByCapaciteBlocBetween(Long minCap, Long maxCap);

    List<Bloc> findByCapaciteBlocLessThan(Long capaciteBloc);

    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);

    List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc);

    List<Bloc> findByNomBlocContaining(String subString);

    List<Bloc> findAllByOrderByNomBlocAsc();

    List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, Long capaciteBloc);

    List<Bloc> findByFoyer_idFoyer(Long idFoyer);

    List<Bloc> findByFoyer_Universite_IdUniversite(Long idUniversite);
}
