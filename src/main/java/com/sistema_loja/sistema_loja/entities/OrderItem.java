package com.sistema_loja.sistema_loja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema_loja.sistema_loja.entities.pk.OrderItemPk;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="tb_order_item")
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class OrderItem {

    @JsonIgnore
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk() ;

    private Integer quantity;
    private double price;



    public OrderItem(Order order, Product product, Integer quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }


    public void setOrder(Order order){
        id.setOrder(order);
    }



    public Product getProduct(){
        return id.getProduct();
    }


    public void setProduct(Product product){
        id.setProduct(product);
    }


    public Double getSubTotal(){
        return price * quantity;
    }
}
