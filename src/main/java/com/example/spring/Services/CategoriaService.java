package com.example.spring.Services;

import com.example.spring.Entities.Categoria;
import com.example.spring.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements BaseService<Categoria>{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional //Crea el inicio de la transacción. el commit de la misma y en caso de error el rollback
    public List<Categoria> findAll() throws Exception {
        try {
            List<Categoria> entities= categoriaRepository.findAll();
            return entities;
        }catch (Exception e){
    throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public Categoria findByID(Long id) throws Exception {
        try {

            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            return entityOptional.get();

        }catch (Exception e){
    throw new Exception((e.getMessage()));
        }
    }

    @Override
    @Transactional
    public Categoria save(Categoria entity) throws Exception {
        try {
            entity = categoriaRepository.save(entity);
            return entity;
        }catch (Exception e){
    throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria update(Long id, Categoria entity) throws Exception {
        try {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            Categoria categoria = entityOptional.get();
           // categoria= categoriaRepository.save(categoria);
            return categoriaRepository.save(categoria);
        }catch (Exception e){
        throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(categoriaRepository.existsById(id)){
                categoriaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
