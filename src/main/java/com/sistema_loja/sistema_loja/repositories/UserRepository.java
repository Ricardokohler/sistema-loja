package com.sistema_loja.sistema_loja.repositories;



import com.sistema_loja.sistema_loja.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
}
