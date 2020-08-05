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

import com.dulcerialaprincipal.web.app.models.entity.Producto;
import com.dulcerialaprincipal.web.app.models.service.IProductoService;

@Controller
public class ModificarProductoController {

	@Autowired
	private IProductoService productoService;

	@RequestMapping(value = "/home/homeproducto/consultarinventario/modificarproducto/{codigo}")
	public String modificarProducto(@PathVariable(value = "codigo") Integer codigo, Map<String, Object> model) {
		Producto producto = null;
		producto = productoService.editarProducto(codigo);
		model.put("producto", producto);
		return "modificarproducto";
	}

	@RequestMapping(value = "/home/homeproducto/consultarinventario/modificarproducto", method = RequestMethod.POST)
	public String actualizarProducto(@Valid Producto producto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Modificar producto");
			return "registrarproducto";
		}
		productoService.guardarProductos(producto);
		return "redirect:/home/homeproducto/consultarinventario";
	}
}
