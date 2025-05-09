package com.example.oumayma_nfikha_tpfoyer.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name ="Foyer")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foyer")  
    Long idFoyer;
    @Column(name ="nomFoyer")
    String nomFoyer;
    @Column(name ="capaciteFoyer")
    Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bloc> blocs;


}
