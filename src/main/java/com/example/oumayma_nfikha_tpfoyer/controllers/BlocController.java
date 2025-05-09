package com.example.oumayma_nfikha_tpfoyer.controllers;

import com.example.oumayma_nfikha_tpfoyer.Entite.Bloc;
import com.example.oumayma_nfikha_tpfoyer.Entite.Foyer;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IBlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    private final IBlocService blocService;

    @Autowired
    public BlocController(IBlocService blocService) {
        this.blocService = blocService;
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.add(bloc);
    }

    @PostMapping("/all")
    public List<Bloc> addAllBlocs(@RequestBody List<Bloc> blocs) {
        return blocService.addAll(blocs);
    }

    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        bloc.setIdBloc(id);
        return blocService.update(bloc);
    }

    @PutMapping("/updateAll")
    public List<Bloc> updateAllBlocs(@RequestBody List<Bloc> blocs) {
        return blocService.updateAll(blocs);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBlocById(@PathVariable Long id) {
        blocService.deleteById(id);
        return blocService.findById(id) == null;
    }

    @DeleteMapping
    public void deleteBloc(@RequestBody Bloc bloc) {
        blocService.delete(bloc);
    }

    @GetMapping
    public List<Bloc> findAllBlocs() {
        return blocService.findAll();
    }

    @GetMapping("/{id}")
    public Bloc findBlocById(@PathVariable Long id) {
        return blocService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public Boolean existsById(@PathVariable Long id) {
        return blocService.existsById(id);
    }

    @GetMapping("/count")
    public Long countBlocs() {
        return blocService.count();
    }

    @DeleteMapping("/all")
    public void deleteAllBlocs() {
        blocService.deleteAll();
    }

    @GetMapping("/name")
    public Bloc getBlocsByNom(@RequestParam String nomBloc) {
        return blocService.findByBlocName(nomBloc);
    }

    @GetMapping("/capacity")
    public List<Bloc> getBlocsByCapacity(@RequestParam Long capacity) {
        return blocService.findByCapacity(capacity);
    }

    @GetMapping("/capacity/{inf}/{supp}")
    public List<Bloc> getBlocByCapacityBetween(@PathVariable Long inf, @PathVariable Long supp) {
        return blocService.findByCapaciteBlocBetween(inf, supp);
    }

    @GetMapping("/capacity-less-than")
    public List<Bloc> getBlocsByCapacityLessThan(@RequestParam Long capaciteBloc) {
        return blocService.findByCapaciteBlocLessThan(capaciteBloc);
    }

    @GetMapping("/name-ignore-case")
    public List<Bloc> getBlocsByNomIgnoreCase(@RequestParam String nomBloc) {
        return blocService.findByNomBlocIgnoreCase(nomBloc);
    }

    @GetMapping("/capacity-greater-than")
    public List<Bloc> getBlocsByCapacityGreaterThan(@RequestParam Long capaciteBloc) {
        return blocService.findByCapaciteBlocGreaterThan(capaciteBloc);
    }

    @GetMapping("/name-containing")
    public List<Bloc> getBlocsByNomContaining(@RequestParam String subString) {
        return blocService.findByNomBlocContaining(subString);
    }

    @GetMapping("/order-by-name")
    public List<Bloc> getAllBlocsOrderedByName() {
        return blocService.findAllByOrderByNomBlocAsc();
    }

    @GetMapping("/foyer/{idFoyer}")
    public List<Bloc> getBlocsByFoyer(@PathVariable Long idFoyer) {
        return blocService.findByFoyer_idFoyer(idFoyer);
    }

    @GetMapping("/foyer/universite/{idUniversite}")
    public List<Bloc> getBlocsByUniversite(@PathVariable Long idUniversite) {
        return blocService.findByFoyer_Universite_IdUniversite(idUniversite);
    }

    @GetMapping("/{nomBloc}/{capaciteBloc}")
    public List<Bloc> getByNomBlocAndCapaciteBloc(@PathVariable String nomBloc, @PathVariable Long capaciteBloc) {
        return blocService.findByNomBlocAndCapaciteBloc(nomBloc, capaciteBloc);
    }

    @GetMapping("/{nomBloc}/OR/{capaciteBloc}")
    public List<Bloc> findByNomBlocOrCapaciteBloc(@PathVariable String nomBloc, @PathVariable Long capaciteBloc) {
        return blocService.findByNomBlocOrCapaciteBloc(nomBloc, capaciteBloc);
    }
    @PostMapping("/affecterBlocWithChambre")
    public Bloc affecterBlocWithChambre(@RequestBody Bloc bloc){
        return blocService.affecterBlocWithChambre(bloc);
    }

    @PutMapping("/{nomFoyer}/blocs/{nomBloc}")
    public Bloc affecterBlocAFoyer(
            @PathVariable String nomFoyer,
            @PathVariable String nomBloc) {

        return blocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }
}