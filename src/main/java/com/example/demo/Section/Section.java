package com.example.demo.Section;

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
public class Section {

    @SequenceGenerator(
            name = "section_sequence",
            sequenceName = "section_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "section_sequence")
    private Long id;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_section", referencedColumnName = "id")
    List<Production> productions = new ArrayList<>();


    public Section(String nom) {
        this.nom = nom;

    }

    public Section(Section section) {

    }

    public Section(Object o) {
        Section section =(Section) o;
        this.id = section.getId();
        this.nom = section.getNom();

    }
}
