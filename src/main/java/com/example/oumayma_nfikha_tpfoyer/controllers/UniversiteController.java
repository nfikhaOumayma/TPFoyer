package com.example.oumayma_nfikha_tpfoyer.controllers;

import com.example.oumayma_nfikha_tpfoyer.Entite.Universite;
import com.example.oumayma_nfikha_tpfoyer.Services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController implements Serializable {

    @Autowired
    private UniversiteService universiteService;

    @PostMapping
    public Universite createUniversite(@RequestBody Universite universite) {
        return universiteService.add(universite);
    }

    @PostMapping("/all")
    public List<Universite> addAllUniversites(@RequestBody List<Universite> universites) {
        return universiteService.addAll(universites);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.findAll();
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.findById(id);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        universite.setIdUniversite(id);
        return universiteService.update(universite);
    }

    @PutMapping("/updateAll")
    public List<Universite> updateAllUniversites(@RequestBody List<Universite> universites) {
        return universiteService.updateAll(universites);
    }

    @DeleteMapping
    public void deleteUniversite(@RequestBody Universite universite) {
        universiteService.delete(universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversiteById(@PathVariable Long id) {
        if (universiteService.existsById(id)) {
            universiteService.deleteById(id);
        }
    }

    @DeleteMapping("/all")
    public void deleteAllUniversites() {
        universiteService.deleteAll();
    }

    @GetMapping("/exists/{id}")
    public Boolean existsById(@PathVariable Long id) {
        return universiteService.existsById(id);
    }

    @GetMapping("/count")
    public Long countUniversites() {
        return universiteService.count();
    }
}