package com.example.spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.Entities.HistorialPedidos;
import com.example.spring.Repositories.HistorialPedidosRepository;

@Service
public class HistorialPedidosService implements BaseService<HistorialPedidos>{

    @Autowired
    private HistorialPedidosRepository historialPedidosRepository;
    
    @Override
    @Transactional
    public List<HistorialPedidos> findAll() throws Exception {
        try {
            List<HistorialPedidos> entities = historialPedidosRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public HistorialPedidos findByID(Long id) throws Exception {
        try {
            Optional<HistorialPedidos> entityOptional = historialPedidosRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public HistorialPedidos save(HistorialPedidos entity) throws Exception {
        try {
            entity = historialPedidosRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public HistorialPedidos update(Long id, HistorialPedidos entity) throws Exception {
        try {
            Optional<HistorialPedidos> entityOptional = historialPedidosRepository.findById(id);
            HistorialPedidos historialPedidos = entityOptional.get();
            historialPedidos = historialPedidosRepository.save(entity);
            return historialPedidos;
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (historialPedidosRepository.existsById(id)){
                historialPedidosRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }
    
}
