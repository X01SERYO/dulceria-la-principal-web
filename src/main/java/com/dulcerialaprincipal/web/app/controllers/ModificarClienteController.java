package com.dulcerialaprincipal.web.app.controllers;

import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dulcerialaprincipal.web.app.models.entity.Cliente;
import com.dulcerialaprincipal.web.app.models.service.IClienteService;

@Controller
public class ModificarClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/home/homeventa/consultacliente/modificarcliente/{idcliente}")
	public String modificarProveedor(@PathVariable(value = "idcliente") Integer idcliente, Map<String, Object> model) {
		Cliente cliente = null;
		cliente = clienteService.editarCliente(idcliente);
		model.put("cliente", cliente);
		model.put("cliente", cliente);
		return "modificarcliente";
	}

	@RequestMapping(value = "/home/homeventa/consultacliente/modificarcliente", method = RequestMethod.POST)
	public String actualizarProducto(@Valid Cliente cliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Modificar cliente");
			return "registrarcliente";
		}
		clienteService.guardarCliente(cliente);
		return "redirect:/home/homeventa/consultacliente/";
	}
}
