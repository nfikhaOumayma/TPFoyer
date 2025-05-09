package com.example.oumayma_nfikha_tpfoyer.repositories;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {

    List<Foyer> findByBlocs_IdBloc(Long idBloc);

    Foyer findByIdFoyerAndBlocs_IdBloc(Long idFoyer, Long idBloc);

    List<Foyer> findByBlocs_IdBlocAndCapaciteFoyer(Long idBloc, Long capaciteFoyer);

    Foyer findByBlocs_IdBlocAndUniversite_IdUniversite(Long idBloc, Long idUniversite);

    Foyer findByNomFoyer(String nomFoyer);
}
