package com.kodlama.io.languageSpringExample.entities.concretes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "language",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    //@JoinColumn(name = "languageId", referencedColumnName = "id")
    private List<SubTechnologie> subTechnologies;

}