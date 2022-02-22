package com.example.demo.chaine;

import com.example.demo.ad.Production;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Chaine {

    @SequenceGenerator(
            name = "chaine_sequence",
            sequenceName = "chaine_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "chaine_sequence")
    private Long id;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_chaine", referencedColumnName = "id")
    List<Production> productions = new ArrayList<>();


    public Chaine(String nom) {
        this.nom = nom;

    }

    public Chaine(Chaine chaine) {

    }

    public Chaine(Object o) {
        Chaine chaine =(Chaine) o;
        this.id = chaine.getId();
        this.nom = chaine.getNom();

    }
}
