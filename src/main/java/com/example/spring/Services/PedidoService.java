package com.example.spring.Services;

import com.example.spring.Entities.Factura;
import com.example.spring.Entities.Pedido;

import com.example.spring.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements BaseService<Pedido> {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    @Transactional //Crea el inicio de la transacción. el commit de la misma y en caso de error el rollback
    public List<Pedido> findAll() throws Exception {
        try {
            List<Pedido> entities= pedidoRepository.findAll();
            return entities;
        }catch (Exception e){
    throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public Pedido findByID(Long id) throws Exception {
        try {

            Optional<Pedido> entityOptional = pedidoRepository.findById(id);
            return entityOptional.get();

        }catch (Exception e){
    throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public Pedido save(Pedido entity) throws Exception {
        try {
            entity = pedidoRepository.save(entity);
            return entity;
        }catch (Exception e){
    throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido update(Long id, Pedido entity) throws Exception {
        try {
            Optional<Pedido> entityOptional = pedidoRepository.findById(id);
            Pedido pedido = entityOptional.get();
           // categoria= categoriaRepository.save(categoria);
            return pedidoRepository.save(pedido);
        }catch (Exception e){
        throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(pedidoRepository.existsById(id)){
                pedidoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
