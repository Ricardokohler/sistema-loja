package com.sistema_loja.sistema_loja.repositories;



import com.sistema_loja.sistema_loja.entities.Order;
import com.sistema_loja.sistema_loja.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{
}
