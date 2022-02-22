package com.example.demo.ad;


import com.example.demo.Section.Section;
import com.example.demo.chaine.Chaine;
import com.example.demo.person.Person;
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
public class Production {

    @SequenceGenerator(
            name = "ad_sequence",
            sequenceName = "ad_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ad_sequence")
    private Long id;
    private String dateProduction;
    private String nameChaine;
    private String nameSection;
    private Long id_section;
    private Long id_chaine;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_production", referencedColumnName = "id")
    List<Person> persons = new ArrayList<>();



    public Production(String dateProduction, Long id_chaine, Long id_section) {
        this.dateProduction = dateProduction;
        this.id_chaine = id_chaine;
        this.id_section = id_section;

    }

    public Production(Production ad) {

    }

    public Production(Object o) {
        Production ad =(Production) o;
        this.id = ad.getId();
        this.dateProduction = ad.getDateProduction();
    }
}
