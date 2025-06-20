package com.sistema_loja.sistema_loja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_CategorY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Category {
    private static final long serialVersionId = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories") //associa a coleção à outra coleção externa, que está anotada com a criação da tabela associativa
    private Set <Product> products = new HashSet<>();


    //contrutor para testes

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
