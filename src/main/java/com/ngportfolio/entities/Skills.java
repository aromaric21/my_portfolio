package com.ngportfolio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@Data                     // génère getters, setters, toString, equals, hashCode
@AllArgsConstructor       // constructeur avec tous les champs
@NoArgsConstructor       // constructeur vide
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String domain;
    public String graduate;
    private String category;

}
