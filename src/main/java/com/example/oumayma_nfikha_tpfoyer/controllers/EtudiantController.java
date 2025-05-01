package com.example.oumayma_nfikha_tpfoyer.controllers;

import com.example.oumayma_nfikha_tpfoyer.Entite.Etudiant;
import com.example.oumayma_nfikha_tpfoyer.Services.IServices.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    private final IEtudiantService etudiantService;

    @Autowired
    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.add(etudiant);
    }

    @PostMapping("/all")
    public List<Etudiant> addAllEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addAll(etudiants);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        etudiant.setIdEtudiant(id);
        return etudiantService.update(etudiant);

    }
    @PutMapping("/updateAll")
    public List<Etudiant> updateAllEtudiants(@RequestBody List<Etudiant>  etudiants) {
        return etudiantService.updateAll(etudiants);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEtudiantById(@PathVariable Long id) {
        etudiantService.deleteById(id);
        return etudiantService.findById(id) == null;
    }

    @DeleteMapping
    public void deleteEtudiant(@PathVariable Etudiant etudiant) {
        etudiantService.delete(etudiant);
    }

    @GetMapping
    public List<Etudiant> findAllEtudiants() {
        return  etudiantService.findAll();
    }

    @GetMapping("/{id}")
    public Etudiant findEtudiantById(@PathVariable Long id) {
        return etudiantService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public Boolean existsById(@PathVariable Long id) {
        return etudiantService.existsById(id);
    }

    @GetMapping("/count")
    public Long countBlocs() {
        return etudiantService.count();
    }

    @DeleteMapping("/all")
    public void deleteAllBlocs() {
        etudiantService.deleteAll();
    }

}
