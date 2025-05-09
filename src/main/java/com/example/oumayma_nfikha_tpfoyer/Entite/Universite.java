package com.example.oumayma_nfikha_tpfoyer.Entite;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity //c'est un entité JBA
@Table(name ="Universite") //définir le nom de la table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUniversite;
    @Column(name="nomUniversite")
    String nomUniversite;
    @Column(name="adresse")
    String adresse;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Foyer foyer;

}
