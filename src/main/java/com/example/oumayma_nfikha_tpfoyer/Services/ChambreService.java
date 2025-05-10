package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IChambreService;
import com.example.oumayma_nfikha_tpfoyer.repositories.BlocRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.ChambreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Component
public class ChambreService implements IChambreService {

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    BlocRepository blocRepository;

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

    @Override
    public List<Chambre> getChambreParNomBloc(String nomBloc) {
        //chercher les bloc dans chambre where nomBloc

        List <Chambre> chambreList = this.findAll();
        List <Chambre> chambreList2 = new ArrayList<>();
        for(Chambre chambre : chambreList){
            if (chambre.getNumeroChambre().equals(nomBloc)){
                chambreList2.add(chambre);
            }

        }
        return chambreList2;
    }

    @Override
    public List<Chambre> getChambresParNomBlocKeyword(String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numeroChambre, String nomBloc) {
      Bloc b = blocRepository.findByNomBloc(nomBloc);
      List<Chambre> chambreList = new ArrayList<>();

      for (Long numeroChambre1 : numeroChambre) {
          chambreList.add(chambreRepository.findByNumeroChambre(numeroChambre1));
      }
      for (Chambre chambre : chambreList) {
          chambre.setBloc(b);
          chambreRepository.save(chambre);
      }

      return b;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return chambreRepository.countByTypeAndBloc(type, idBloc);
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void listeChambreParBloc() {
        List<Chambre> chambres = chambreRepository.findChambresGroupedByBloc();


            for (Chambre chambre : chambres) {
                log.info("Chambre ID: {}, Numéro: {}, Type: {}, Bloc: {}",
                        chambre.getIdChambre(),
                        chambre.getNumeroChambre(),
                        chambre.getTypeC(),
                        chambre.getBloc() != null ? chambre.getBloc().getIdBloc() : "Sans bloc");
            }
        }



}
