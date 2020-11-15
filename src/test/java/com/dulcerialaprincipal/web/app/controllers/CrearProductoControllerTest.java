package com.dulcerialaprincipal.web.app.controllers;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.dulcerialaprincipal.web.app.models.entity.Producto;

class CrearProductoControllerTest {
	
	//@Test
	/*void guardarProductoTest() {
		String esperado= "redirect:consultarinventario";
		CrearProductoController a = new CrearProductoController();
		Producto producto = new Producto();
		producto.setCodigo(123);
		producto.setNombre("Gomitas");
		producto.setPrecio(1300.0);
		String resultado=a.guardarProducto(producto);
		assertEquals(esperado, resultado);
		
	}*/
	
	@Test
	void guardarProductoTest() {
		CrearProductoController a = new CrearProductoController();
		Producto producto = new Producto();
		producto.setCodigo(890);
		producto.setNombre("Gomitas");
		producto.setPrecio(1300.0);
		
		Throwable exception = assertThrows(SQLException.class,()->{a.guardarProducto(producto);} );
	   	}

}
