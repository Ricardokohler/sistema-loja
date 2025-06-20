package com.sistema_loja.sistema_loja.repositories;



import com.sistema_loja.sistema_loja.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{
}
