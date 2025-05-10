package com.example.oumayma_nfikha_tpfoyer.Services.IServices;

import com.example.oumayma_nfikha_tpfoyer.Entite.Bloc;
import com.example.oumayma_nfikha_tpfoyer.Entite.Chambre;
import com.example.oumayma_nfikha_tpfoyer.Entite.TypeChambre;

import java.time.LocalDate;
import java.util.List;

public interface IChambreService {
    Chambre add(Chambre chambre);

    List<Chambre> addAll(List<Chambre> chambres);

    Chambre update(Chambre chambre);

    List<Chambre> updateAll(List<Chambre> chambres);

    void delete(Chambre chambre);

    void deleteById(Long id);

    void deleteAll();

    List<Chambre> findAll();

    Chambre findById(Long id);

    boolean existsById(Long id);

    Long count();

    Chambre findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByTypeC(TypeChambre typeC);

    List<Chambre> findByBloc_IdBloc(Long idBloc);

    List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc, TypeChambre typeC);

    Chambre findByNumeroChambreAndTypeC(Long numeroChambre, TypeChambre typeC);


    List<Chambre> findByBloc_Foyer_NomFoyerAndReservations_AnneUniversitaireAndReservations_Etudiants_NomEt(
            String nomFoyer, LocalDate anneUniversitaire, String nomEtudiant);

    Long countByTypeCAndBloc_Foyer_NomFoyer(TypeChambre typeC, String nomFoyer);

    List<Chambre>  getChambreParNomBloc(String nomBloc);

    List<Chambre> getChambresParNomBlocKeyword(String nomBloc);

    Bloc affecterChambresABloc(List<Long> numeroChambre, String nomBloc);

    long nbChambreParTypeEtBloc( TypeChambre type, long idBloc) ;

    void listeChambreParBloc();
}
