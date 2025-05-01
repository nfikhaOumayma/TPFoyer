package com.example.oumayma_nfikha_tpfoyer.controllers;

import com.example.oumayma_nfikha_tpfoyer.Entite.Chambre;
import com.example.oumayma_nfikha_tpfoyer.Entite.TypeChambre;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class ChambreController {

    private final IChambreService chambreService;

    @Autowired
    public ChambreController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.add(chambre);
    }

    @PostMapping("/all")
    public List<Chambre> addAllChambres(@RequestBody List<Chambre> chambres) {
        return chambreService.addAll(chambres);
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        chambre.setIdChambre(id);
        return chambreService.update(chambre);
    }

    @PutMapping("/updateAll")
    public List<Chambre> updateAllChambres(@RequestBody List<Chambre>  chambres) {
        return chambreService.updateAll(chambres);
    }

    @DeleteMapping("/{id}")
    public boolean deleteChambreById(@PathVariable Long id) {
        chambreService.deleteById(id);
        return chambreService.findById(id) == null;
    }

    @DeleteMapping
    public void deleteChambre(@PathVariable Chambre chambre) {
        chambreService.delete(chambre);
    }

    @GetMapping
    public List<Chambre> findAllChambres() {
        return  chambreService.findAll();
    }

    @GetMapping("/{id}")
    public Chambre findChambreById(@PathVariable Long id) {
        return chambreService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public Boolean existsById(@PathVariable Long id) {
        return chambreService.existsById(id);
    }

    @GetMapping("/count")
    public Long countChambres() {
        return chambreService.count();
    }

    @DeleteMapping("/all")
    public void deleteAllChambres() {
        chambreService.deleteAll();
    }


    @GetMapping("/{numeroChambre}")
    public Chambre findByNumeroChambre(@PathVariable Long numeroChambre) {
        return chambreService.findByNumeroChambre(numeroChambre);
    }

    @GetMapping("/type/{typeC}")
    public List<Chambre> findByTypeC(@PathVariable TypeChambre typeC) {
        return chambreService.findByTypeC(typeC);
    }

    @GetMapping("/bloc/{idBloc}")
    public List<Chambre> findByBlocId(@PathVariable Long idBloc) {
        return chambreService.findByBloc_IdBloc(idBloc);
    }

    @GetMapping("/bloc/{idBloc}/type/{typeC}")
    public List<Chambre> findByBlocIdAndTypeC(@PathVariable Long idBloc, @PathVariable TypeChambre typeC) {
        return chambreService.findByBloc_IdBlocAndTypeC(idBloc, typeC);

    }

    @GetMapping("/numero/{numeroChambre}/type/{typeC}")
    public Chambre findByNumeroChambreAndTypeC(@PathVariable Long numeroChambre, @PathVariable TypeChambre typeC) {
        return chambreService.findByNumeroChambreAndTypeC(numeroChambre, typeC);
    }

    @GetMapping("/foyer/{nomFoyer}/reservations/annee/{anneUniversitaire}/etudiant/{nomEtudiant}")
    public List<Chambre> findByFoyerAndReservations(
            @PathVariable String nomFoyer,
            @PathVariable LocalDate anneUniversitaire,
            @PathVariable String nomEtudiant) {
        return chambreService.findByBloc_Foyer_NomFoyerAndReservations_AnneUniversitaireAndReservations_Etudiants_NomEt(nomFoyer, anneUniversitaire, nomEtudiant);
    }

    @GetMapping("/count/type/{typeC}/foyer/{nomFoyer}")
    public Long countByTypeCAndFoyer(@PathVariable TypeChambre typeC, @PathVariable String nomFoyer) {
        return   chambreService.countByTypeCAndBloc_Foyer_NomFoyer(typeC, nomFoyer);
    }
}