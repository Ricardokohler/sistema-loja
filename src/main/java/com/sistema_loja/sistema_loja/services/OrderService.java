package com.sistema_loja.sistema_loja.services;


import com.sistema_loja.sistema_loja.entities.Order;
import com.sistema_loja.sistema_loja.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;




    //CREATE
    public Order create(Order Order) {

        try{
            return orderRepository.save(Order);
        } catch (RuntimeException e) {

            throw new RuntimeException(e.getMessage());
        }

    }





    //GET BY ID
    public Order getById(Long id) {
        Optional <Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()){
            return optionalOrder.get();

        } else {
            throw new RuntimeException("Id não encontrado");

        }
    }




    //GET ALL
    public List <Order> getAll() {

        return orderRepository.findAll();
    }



    

    //Delete
    public void delete(long id) {
        Optional <Order> deletedOrder = orderRepository.findById(id);

        if(deletedOrder.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }





    //Update
    public Order update(Order Order, long id) {
        Optional<Order> oldOrder = orderRepository.findById(id);

        if (oldOrder.isPresent()) {
            Order newOrder = oldOrder.get();

            newOrder.setMoment(Order.getMoment());

            return orderRepository.save(newOrder);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }




}
