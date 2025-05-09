package com.example.oumayma_nfikha_tpfoyer.repositories;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    Chambre findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByTypeC(TypeChambre typeC);

    List<Chambre> findByBloc_IdBloc(Long idBloc);

    List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc, TypeChambre typeC);

    Chambre findByNumeroChambreAndTypeC(Long numeroChambre, TypeChambre typeC);


    List<Chambre> findByBloc_Foyer_NomFoyerAndReservations_AnneUniversitaireAndReservations_Etudiants_NomEt(
            String nomFoyer, LocalDate anneUniversitaire, String nomEtudiant);

    Long countByTypeCAndBloc_Foyer_NomFoyer(TypeChambre typeC, String nomFoyer);

    List<Chambre> findByBlocNomBloc(String nomBloc);

    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.typeC = :type AND c.bloc.idBloc = :idBloc")
    long countByTypeAndBloc(@Param("type") TypeChambre type, @Param("idBloc") long idBloc);
}

