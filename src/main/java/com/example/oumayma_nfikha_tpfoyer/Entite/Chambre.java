package com.example.oumayma_nfikha_tpfoyer.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity //c'est un entité JBA
@Table(name ="Chambre") //définir le nom de la table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;

    Long numeroChambre;

    @Column(name="typeC")
    @Enumerated(EnumType.STRING)
    TypeChambre typeC ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Bloc bloc;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reservation> reservations;

}
