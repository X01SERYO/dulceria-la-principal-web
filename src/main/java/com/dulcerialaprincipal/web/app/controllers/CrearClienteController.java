package com.dulcerialaprincipal.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dulcerialaprincipal.web.app.models.entity.Cliente;
import com.dulcerialaprincipal.web.app.models.service.IClienteService;

@Controller
public class CrearClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/home/homeventa/registrarcliente")
	public String registrarCliente(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Registrar cliente");

		return "registrarcliente";
	}

	@RequestMapping(value = "/home/homeventa/registrarcliente", method = RequestMethod.POST)
	public String guardarCliente(@Valid Cliente cliente) {

		clienteService.registrarClientes(cliente);
		return "redirect:consultacliente";
	}
}
