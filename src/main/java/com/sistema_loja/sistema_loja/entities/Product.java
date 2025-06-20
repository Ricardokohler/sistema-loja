package com.sistema_loja.sistema_loja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Product {
    private static final long serialVersionId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;


    //Asociação com Category
    @ManyToMany
    @JoinTable(name= "tb_Product_Category",  //cria a tabela de associação e da o nome pra ela
    joinColumns = @JoinColumn (name = "id_Product"), //associa a classe atual a partir do id
    inverseJoinColumns = @JoinColumn (name="id_Category")) //associa a classe externa a partir do id
    private Set <Category> categories = new HashSet<>();


    //Associação com OrderItems
    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private Set <OrderItem> items =new HashSet<>();

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    @JsonIgnore// esta dando erro nessa relação -
    public Set <Order> getOrders(){
        Set <Order> set = new HashSet<>();
        for (OrderItem x  : items) {
            set.add(x.getOrder());
        }
        return set;
    }
}
