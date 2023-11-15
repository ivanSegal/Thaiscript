package com.example.spring.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.Entities.DetallePedido;
import com.example.spring.Repositories.DetallePedidoRepository;

@Service
public class DetallePedidoService implements BaseService<DetallePedido>{
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	

	@Override
	@Transactional
	public List<DetallePedido> findAll() throws Exception {
		try {
			List <DetallePedido> entities = detallePedidoRepository.findAll();
			return entities;
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}		
	}

	@Override
	@Transactional
	public DetallePedido findByID(Long id) throws Exception {
		try {
			Optional <DetallePedido> entityOptional = detallePedidoRepository.findById(id);
			return entityOptional.get();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public DetallePedido save(DetallePedido entity) throws Exception {
		try {
			entity = detallePedidoRepository.save(entity);
			return entity;
		} catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

	@Override
	@Transactional
	public DetallePedido update(Long id, DetallePedido entity) throws Exception {
		try {
			Optional<DetallePedido> entityOptional = detallePedidoRepository.findById(id);
			DetallePedido detallePedido = entityOptional.get();
			detallePedido = detallePedidoRepository.save(entity);
			return detallePedido;
		} catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if(detallePedidoRepository.existsById(id)) {
				detallePedidoRepository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

}
