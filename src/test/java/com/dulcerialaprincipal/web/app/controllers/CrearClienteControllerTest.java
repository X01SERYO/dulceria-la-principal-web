package com.dulcerialaprincipal.web.app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dulcerialaprincipal.web.app.models.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrearClienteControllerTest {
	@Autowired
	private CrearClienteController crear;
		
	@org.junit.jupiter.api.Test
	public void Atest() {
		String esperado ="redirect:consultacliente";
		Cliente cliente = new Cliente();
		cliente.setIdcliente(52634577);
		cliente.setNombre("Omaira Arias");
		assertEquals(esperado, crear.guardarCliente(cliente,null));
	}
	
	@org.junit.jupiter.api.Test
	public void Btest() {
		String esperado ="redirect:registrarcliente";
		Cliente cliente = new Cliente();
		cliente.setIdcliente(52634577);
		cliente.setNombre("Omaira Arias");
		assertEquals(esperado, crear.guardarCliente(cliente,null));
	}

}
