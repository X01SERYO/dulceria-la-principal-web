package com.dulcerialaprincipal.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dulcerialaprincipal.web.app.models.service.IClienteService;

@Controller
public class BuscarClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/home/homeventa/consultacliente", method = RequestMethod.GET)
	public String consultaCliente(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "consultacliente";
	}

	@PostMapping("/home/homeventa/consultacliente")
	public String buscarClientePorId(@RequestParam(value = "idcliente") Integer idcliente, Map<String, Object> model) {

		model.put("titulo", "Cliente");
		model.put("clientes", clienteService.buscarId(idcliente));
		return "consultacliente";
	}

}
