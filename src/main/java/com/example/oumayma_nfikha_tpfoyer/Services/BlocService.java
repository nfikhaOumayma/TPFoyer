package com.example.oumayma_nfikha_tpfoyer.Services;

import com.example.oumayma_nfikha_tpfoyer.Entite.Bloc;
import com.example.oumayma_nfikha_tpfoyer.Entite.Chambre;
import com.example.oumayma_nfikha_tpfoyer.Entite.Foyer;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IBlocService;
import com.example.oumayma_nfikha_tpfoyer.repositories.BlocRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.ChambreRepository;
import com.example.oumayma_nfikha_tpfoyer.repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BlocService implements IBlocService {

    @Autowired
    BlocRepository blocRepository;

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    FoyerRepository foyerRepository;

    @Override
    public Bloc add(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> addAll(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public Bloc update(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> updateAll(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public void delete(Bloc bloc) { blocRepository.delete(bloc); }

    @Override
    public void deleteById(Long id) { blocRepository.deleteById(id);}

    @Override
    public void deleteAll() { blocRepository.deleteAll();}

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(Long id) {
        return blocRepository.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return blocRepository.existsById(id);
    }

    @Override
    public Long count() {
        return blocRepository.count();
    }

    @Override
    public Bloc findByBlocName(String blocName) {return blocRepository.findByNomBloc(blocName);}

    @Override
    public List<Bloc> findByCapacity(Long capacity) {
        return blocRepository.findByCapaciteBloc(capacity);
    }

    @Override
    public List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, Long capaciteBloc) {
        return blocRepository.findByNomBlocAndCapaciteBloc(nomBloc, capaciteBloc);
    }

    @Override
    public List<Bloc> findByCapaciteBlocBetween(Long minCap, Long maxCap) {
        return blocRepository.findByCapaciteBlocBetween(minCap, maxCap);
    }

    @Override
    public List<Bloc> findByCapaciteBlocLessThan(Long capaciteBloc) {
        return blocRepository.findByCapaciteBlocLessThan(capaciteBloc);
    }

    @Override
    public List<Bloc> findByNomBlocIgnoreCase(String nomBloc) {
        return blocRepository.findByNomBlocIgnoreCase(nomBloc);
    }

    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc) {
        return blocRepository.findByCapaciteBlocGreaterThan(capaciteBloc);
    }

    @Override
    public List<Bloc> findByNomBlocContaining(String subString) {
        return blocRepository.findByNomBlocContaining(subString);
    }

    @Override
    public List<Bloc> findAllByOrderByNomBlocAsc() {
        return blocRepository.findAllByOrderByNomBlocAsc();
    }

    @Override
    public List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, Long capaciteBloc) {
        return blocRepository.findByNomBlocOrCapaciteBloc(nomBloc, capaciteBloc);
    }

    @Override
    public List<Bloc> findByFoyer_idFoyer(Long idFoyer) {

        return blocRepository.findByFoyer_idFoyer(idFoyer);
    }

    @Override
    public List<Bloc> findByFoyer_Universite_IdUniversite(Long idUniversite) {
        return blocRepository.findByFoyer_Universite_IdUniversite(idUniversite);
    }

    @Override
    public Bloc affecterBlocWithChambre(Bloc bloc) {
        for (Chambre c : bloc.getChambres()) {
            c.setBloc(bloc);
            chambreRepository.save(c);
        }
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {

        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);

        Bloc blocs = blocRepository.findByNomBloc(nomBloc);

        Set<Bloc> list = new HashSet<Bloc>();
        list.add(blocs);
        foyer.setBlocs(list);
        foyerRepository.save(foyer);
    return blocs;
    }



}
