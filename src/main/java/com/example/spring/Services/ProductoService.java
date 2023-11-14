package com.example.spring.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.spring.Entities.Producto;
import com.example.spring.Repositories.ProductoRepository;

@Service
public class ProductoService implements BaseService<Producto>{

	private ProductoRepository productoRepository;
	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	@Override
	@Transactional
	public List<Producto> findAll() throws Exception {
		try {
			List <Producto> entities = productoRepository.findAll();
			return entities;
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}		
	}

	@Override
	@Transactional
	public Producto findByID(Long id) throws Exception {
		try {
			Optional <Producto> entityOptional = productoRepository.findById(id);
			return entityOptional.get();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Producto save(Producto entity) throws Exception {
		try {
			entity = productoRepository.save(entity);
			return entity;
		} catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

	@Override
	@Transactional
	public Producto update(Long id, Producto entity) throws Exception {
		try {
			Optional<Producto> entityOptional = productoRepository.findById(id);
			Producto producto = entityOptional.get();
			producto = productoRepository.save(entity);
			return producto;
		} catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if(productoRepository.existsById(id)) {
				productoRepository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

}
