package com.example.oumayma_nfikha_tpfoyer.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity //c'est un entité JBA
@Table(name ="Etudiant") //définir le nom de la table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long IdEtudiant;

    @Column(name ="nomEt", nullable = false)
    String nomEt;

    @Column(name ="prenomEt",nullable = false)
    String prenomEt;

    @Column(name="cin",unique = true)
    String cin;

    @Column(name="ecole")
    String ecole;

    @Column(name="dateNaissance")
    LocalDate dateNaissance;

    @ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations;
}
