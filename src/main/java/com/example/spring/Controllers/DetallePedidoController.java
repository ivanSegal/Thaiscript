package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Entities.DetallePedido;
import com.example.spring.Services.DetallePedidoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallePedidos")
public class DetallePedidoController {
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.findAll());
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente nuevamente.\"}");
		}
	}

	@GetMapping("/{id}")
	
	public ResponseEntity<?> getOne(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.findByID(id));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente nuevamente.\"}");
		}
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody DetallePedido entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.save(entity));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, porfavor intente nuevamente.\"}");
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DetallePedido entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.update(id, entity));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, porfavor intente nuevamente.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(detallePedidoService.delete(id));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, porfavor intente nuevamente.\"}");
		}
	}
}
