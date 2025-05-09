package com.example.oumayma_nfikha_tpfoyer.repositories;

import com.example.oumayma_nfikha_tpfoyer.Entite.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
  Etudiant findByNomEtAndPrenomEt(String nom , String prenom);

  Etudiant findByCin(String cin);

}
