package com.example.oumayma_nfikha_tpfoyer.controllers;

import com.example.oumayma_nfikha_tpfoyer.Entite.Foyer;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IFoyerService;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/foyer")
public class FoyerController implements Serializable {

    private final IFoyerService  foyerService;

    @Autowired
    public FoyerController(IFoyerService foyerService, ReturnTypeParser returnTypeParser) {
        this.foyerService = foyerService;
    }
    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.add(foyer);
    }

    @PostMapping("/all")
    public List<Foyer> addAllFoyer(@RequestBody List<Foyer> foyers) {
        return foyerService.addAll(foyers);
    }

    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        foyer.setIdFoyer(id);
        return foyerService.update(foyer);
    }

    @PutMapping("/updateAll")
    public List<Foyer> updateAllFoyers(@RequestBody List<Foyer>  foyers) {
        return foyerService.updateAll(foyers);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFoyerById(@PathVariable Long id) {
        foyerService.deleteById(id);
        return foyerService.findById(id) == null;
    }

    @DeleteMapping
    public void deleteFoyer(@RequestBody Foyer foyer) {
        foyerService.delete(foyer);
    }
    @GetMapping
    public List<Foyer> findAllFoyers() {
        return foyerService.findAll();
    }

    @GetMapping("/{id}")
    public Foyer findFoyerById(@PathVariable Long id) {
        return foyerService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public Boolean existsById(@PathVariable Long id) {
        return  foyerService.existsById(id);
    }

    @GetMapping("/count")
    public Long countFoyers() {
        return foyerService.count();
    }

    @DeleteMapping("/all")
    public String deleteAllFoyers() {
        foyerService.deleteAll();
        return "All blocks deleted";
    }

    @PutMapping("/affect")
    public String affectFoyer(@RequestParam Long idf , @RequestParam Long idU) {
        foyerService.affecterFoyerUnivrsite(idf , idU);
        return "Foyer affected";
    }

    @GetMapping("/blocs/{idBloc}")
    public  List<Foyer> findByBlocs_IdBloc(@RequestParam Long idBloc) {
        return foyerService.findByBlocs_IdBloc(idBloc);
    }

    @GetMapping("/blocs/{idFoyer}/{idBloc}")
    public Foyer findByIdFoyerAndBlocs_IdBloc(@RequestParam Long idFoyer, @RequestParam Long idBloc) {
        return foyerService.findByIdFoyerAndBlocs_IdBloc(idFoyer,idBloc);
    }

    @GetMapping("/{idBloc}/{capaciteFoyer}")
    public  List<Foyer> findByBlocs_IdBlocAndCapaciteFoyer(@RequestParam Long idBloc ,@RequestParam Long capaciteFoyer){
        return foyerService.findByBlocs_IdBlocAndCapaciteFoyer(idBloc,capaciteFoyer);
    }

    @GetMapping("/blocs/{idBloc}/university/{idUniversite}")
    public  Foyer findByBlocs_IdBlocAndUniversite_IdUniversite(@RequestParam Long idBloc, @RequestParam Long idUniversite) {
        return foyerService.findByBlocs_IdBlocAndUniversite_IdUniversite(idBloc,idUniversite);
    }
}
