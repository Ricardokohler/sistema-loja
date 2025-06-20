package com.sistema_loja.sistema_loja.repositories;
import com.sistema_loja.sistema_loja.entities.Category;
import com.sistema_loja.sistema_loja.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
