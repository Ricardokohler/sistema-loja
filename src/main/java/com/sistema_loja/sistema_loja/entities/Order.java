package com.sistema_loja.sistema_loja.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema_loja.sistema_loja.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {
    private static final long serialVersionId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    @OneToOne(mappedBy = "order", cascade= CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        super();
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {

        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Double getTotal(){
        double sum = 0.0;
        for(OrderItem x : items){
            sum += x.getSubTotal();
        }

        return sum;
    }
}



