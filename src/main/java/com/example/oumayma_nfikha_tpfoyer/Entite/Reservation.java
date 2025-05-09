package com.example.oumayma_nfikha_tpfoyer.Entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity //c'est un entité JBA
@Table(name ="Reservation") //définir le nom de la table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;

    @Column(name="anneUniversitaire")
    LocalDate anneUniversitaire;

    @Column(name="estValide")
    Boolean estValide;

    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}
