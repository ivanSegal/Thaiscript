package com.example.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(){
		return "index.html";
	}
	
	@GetMapping("/factura")
	public String factura() {
		return "factura.html";
	}
	
	@GetMapping("/historia_pedidos")
	public String historiaPedidos() {
		return "historialPedidos.html";
	}
	
	@GetMapping("/sistema_pedido")
	public String sistemaPedidos() {
		return "sistemapedido.html";
	}
	
	

}
