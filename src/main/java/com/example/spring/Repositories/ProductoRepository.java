package com.example.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.Entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
