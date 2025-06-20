package com.sistema_loja.sistema_loja.entities.pk;

import com.sistema_loja.sistema_loja.entities.Order;
import com.sistema_loja.sistema_loja.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode
public class OrderItemPk {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}
