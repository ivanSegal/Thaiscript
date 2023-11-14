package com.example.spring.Repositories;
import com.example.spring.Entities.Factura;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
    
}

