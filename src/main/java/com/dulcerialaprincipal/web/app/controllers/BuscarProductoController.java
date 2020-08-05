package com.dulcerialaprincipal.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dulcerialaprincipal.web.app.models.service.IProductoService;

@Controller
public class BuscarProductoController {

	@Autowired
	private IProductoService productoService;

	@RequestMapping(value = "/home/homeproducto/consultarinventario", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productoService.findAll());
		return "consultarinventario";
	}

	@RequestMapping(value = "/home/homeproducto/consultarinventario", method = RequestMethod.POST)
	public String buscarProductoPorId(@RequestParam(value = "codigo") Integer codigo, Map<String, Object> model) {

		model.put("titulo", "editar producto");
		model.put("productos", productoService.buscarId(codigo));
		return "consultarinventario";
	}

	@RequestMapping(value = "/home/homecompra/registrarcompra/{idproveedor}", method = RequestMethod.POST)
	public String buscarProductoPorIdRegistarCompra(@RequestParam(value = "codigo") Integer codigo,
			Map<String, Object> model) {

		model.put("titulo", "editar producto");
		model.put("productos", productoService.buscarId(codigo));
		return "registrarcompra";
	}

	/*
	 * @RequestMapping(value = "/home/homeproducto/venta/{idcliente}", method =
	 * RequestMethod.POST) public String
	 * buscarProductoPorIdVenta(@RequestParam(value = "codigo") Integer codigo,
	 * Map<String, Object> model) {
	 * 
	 * model.put("titulo", "editar producto"); model.put("productos",
	 * productoService.buscarId(codigo)); return "venta"; }
	 */
}
