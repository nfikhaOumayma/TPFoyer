package com.example.oumayma_nfikha_tpfoyer.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="Bloc")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;
    String nomBloc;
    Long capaciteBloc;

    @ManyToOne( cascade = CascadeType.ALL)
    @JsonIgnore
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chambre> chambres;

}
