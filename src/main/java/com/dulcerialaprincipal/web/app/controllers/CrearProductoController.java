package com.dulcerialaprincipal.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dulcerialaprincipal.web.app.models.entity.Producto;
import com.dulcerialaprincipal.web.app.models.service.IProductoService;

@Controller
public class CrearProductoController {

	@Autowired
	private IProductoService productoService;
	
	@RequestMapping(value = "/home/homeproducto/registrarproducto")
	public String registrarProducto(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Registrar producto");

		return "registrarproducto";
	}

	@RequestMapping(value = "/home/homeproducto/registrarproducto", method = RequestMethod.POST)
	public String guardarProducto(@Valid Producto producto) {
		System.out.println(producto.getNombre());
		productoService.registrarProductos(producto);
		return "redirect:consultarinventario";
	}
}
