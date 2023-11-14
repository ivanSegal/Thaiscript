package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring.Entities.HistorialPedidos;
import com.example.spring.Services.HistorialPedidosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/historialPedidos")
public class HistorialPedidosController {
    @Autowired
    private HistorialPedidosService historialPedidosService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(historialPedidosService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: getAll Cliente fallo.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(historialPedidosService.findByID(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: getOne Cliente fallo.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody HistorialPedidos entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(historialPedidosService.save(entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: save Cliente fallo.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HistorialPedidos entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(historialPedidosService.update(id,entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: update Cliente fallo.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(historialPedidosService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: delete Cliente fallo.\"}");
        }
    }
}
