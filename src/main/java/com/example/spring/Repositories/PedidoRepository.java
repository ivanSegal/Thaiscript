package com.example.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring.Entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    
}
