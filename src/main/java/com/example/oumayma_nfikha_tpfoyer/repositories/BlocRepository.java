package com.example.oumayma_nfikha_tpfoyer.repositories;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByNomBloc(String nomBloc);

    List<Bloc> findByCapaciteBloc(Long capaciteBloc);

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
