package com.dulcerialaprincipal.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dulcerialaprincipal.web.app.models.entity.Producto;
import com.dulcerialaprincipal.web.app.models.service.IClienteService;
import com.dulcerialaprincipal.web.app.models.service.IProductoService;

@Controller
public class CrearProductoController {

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/home/homeproducto/registrarproducto")
	public String registrarProducto(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Registrar producto");

		return "registrarproducto";
	}

	@RequestMapping(value = "/home/homeproducto/registrarproducto", method = RequestMethod.POST)
	public String guardarProducto(@Valid Producto producto, RedirectAttributes flash) {
		if (clienteService.buscarIdProducto(producto.getCodigo()) == null) {
			productoService.registrarProductos(producto);
			return "redirect:consultarinventario";
		} else {
			flash.addFlashAttribute("error", "Código de producto ya existe");
			return "redirect:registrarproducto";
		}
	}
}
