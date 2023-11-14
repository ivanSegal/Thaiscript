package com.example.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring.Entities.HistorialPedidos;

@Repository
public interface HistorialPedidosRepository extends JpaRepository<HistorialPedidos,Long>{
    
}
