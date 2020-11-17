package com.dulcerialaprincipal.web.app.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dulcerialaprincipal.web.app.models.entity.Producto;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CrearProductoControllerTest {
	
	@Autowired
	private CrearProductoController crear;
	
		
	@org.junit.jupiter.api.Test
	public void Atest() {
		String esperado ="redirect:consultarinventario";
		Producto producto = new Producto();
		producto.setCodigo(1234);
		producto.setNombre("CHOCOLATINA");
		producto.setPrecio(900.0);
		assertEquals(esperado, crear.guardarProducto(producto,null));
	}
	
	@org.junit.jupiter.api.Test
	public void Btest() {
		String esperado1 ="redirect:registrarproducto";
		Producto producto = new Producto();
		producto.setCodigo(1234);
		producto.setNombre("CHOCOLATINA");
		producto.setPrecio(900.0);
		assertEquals(esperado1, crear.guardarProducto(producto,null));
	}
	

}
