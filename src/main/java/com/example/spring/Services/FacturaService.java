package com.example.spring.Services;

import com.example.spring.Entities.Factura;
import com.example.spring.Repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements BaseService<Factura>{

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    @Transactional //Crea el inicio de la transacción. el commit de la misma y en caso de error el rollback
    public List<Factura> findAll() throws Exception {
        try {
            List<Factura> entities= facturaRepository.findAll();
            return entities;
        }catch (Exception e){
    throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public Factura findByID(Long id) throws Exception {
        try {

            Optional<Factura> entityOptional = facturaRepository.findById(id);
            return entityOptional.get();

        }catch (Exception e){
    throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public Factura save(Factura entity) throws Exception {
        try {
            entity = facturaRepository.save(entity);
            return entity;
        }catch (Exception e){
    throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura update(Long id, Factura entity) throws Exception {
        try {
            Optional<Factura> entityOptional = facturaRepository.findById(id);
            Factura categoria = entityOptional.get();
           // categoria= categoriaRepository.save(categoria);
            return facturaRepository.save(categoria);
        }catch (Exception e){
        throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(facturaRepository.existsById(id)){
                facturaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
