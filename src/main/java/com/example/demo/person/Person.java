package com.example.demo.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Person {

    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_sequence")
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String poste;
    private String pourcentage;

    private Long id_production;




}
