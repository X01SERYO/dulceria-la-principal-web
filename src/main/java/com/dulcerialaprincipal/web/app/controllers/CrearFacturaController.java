package com.dulcerialaprincipal.web.app.controllers;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dulcerialaprincipal.web.app.models.entity.Cliente;
import com.dulcerialaprincipal.web.app.models.entity.Factura;
import com.dulcerialaprincipal.web.app.models.entity.ItemFactura;
import com.dulcerialaprincipal.web.app.models.service.IClienteService;

@Controller
@SessionAttributes("factura")
public class CrearFacturaController {

	@Autowired
	private IClienteService clienteService;

	private List<ItemFactura> items;
	private Double granTotal;
	private Factura factura;

	@GetMapping(value = "/home/homeventa/venta/{idcliente}")
	public String crearFactura(@PathVariable(value = "idcliente") Integer idcliente, Map<String, Object> model,
			RedirectAttributes flash) {
		items = new ArrayList<ItemFactura>();
		Cliente cliente = clienteService.buscarUnCliente(idcliente);
		for (int i = 0; i < clienteService.findAllFacturas().size(); i++) {
			System.out.println("FACTURAS   " + clienteService.findAllFacturas().get(i).getIdVenta());
		}

		factura = new Factura();
		factura.setCliente(cliente);
		factura.setIdVenta(clienteService.findAllFacturas().size() + 1);

		model.put("factura", factura);
		model.put("titulo", "Crear Factura");
		granTotal = 0.0;
		if (items.isEmpty()) {

		} else {
			for (int i = 0; i < items.size(); i++) {
				granTotal += items.get(i).getTotal();
			}

			model.put("items", items);
			model.put("granTotal", granTotal);
		}

		return "venta";
	}

	@RequestMapping(value = "/home/homeventa/venta/{idcliente}", method = RequestMethod.POST)
	public String añadirItemProductoAFactura(@RequestParam(value = "codigo") Integer codigo,
			@RequestParam(value = "cantidad") Integer cantidad, Map<String, Object> model, RedirectAttributes flash) {

		ItemFactura item = new ItemFactura();
		model.put("titulo", "Crear Factura");

		try {
			item.setProducto(clienteService.buscarIdProducto(codigo));
			item.setCantidad(cantidad);
			item.setFactura(factura);
			item.setTotal(clienteService.buscarIdProducto(codigo).getPrecio() * cantidad);
			items.add(item);
			granTotal = 0.0;
			for (int i = 0; i < items.size(); i++) {
				granTotal += items.get(i).getTotal();
			}

			model.put("items", items);
			model.put("granTotal", granTotal);

		} catch (Exception e) {
			// TODO: handle exception
			flash.addFlashAttribute("error", "EL producto no existe o la cantidad es invalida");
			granTotal = 0.0;
			for (int i = 0; i < items.size(); i++) {

				granTotal += items.get(i).getTotal();
			}
			model.put("items", items);
			model.put("granTotal", granTotal);
			return "redirect:/home/homeventa/venta/{idcliente}";
		}

		return "venta";
	}

	@RequestMapping(value = "/home/homeventa/venta", method = RequestMethod.POST)
	public String eliminarItemProductoAFactura(@RequestParam(value = "codigo") Integer codigo,
			Map<String, Object> model) {
		model.put("titulo", "Crear Factura");
		granTotal = 0.0;
		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).getProducto().getCodigo().equals(codigo)) {
				items.remove(i);
			}
		}
		for (int i = 0; i < items.size(); i++) {
			granTotal += items.get(i).getTotal();
		}

		model.put("items", items);
		model.put("granTotal", granTotal);

		return "venta";
	}

	@PostMapping("/home/homeventa/venta/")
	public String guardar(Factura factura, RedirectAttributes flash, SessionStatus status) {
		Integer generadorIdItemFactura = 0;
		generadorIdItemFactura = clienteService.findAllItemFacturas().size();
		for (int i = 0; i < items.size(); i++) {
			items.get(i).setFactura(factura);
			items.get(i).setId((generadorIdItemFactura + i + 1));
			factura.addItemFactura(items.get(i));

		}
		for (int i = 0; i < factura.getItems().size(); i++) {

			System.out.println(factura.getItems().get(i).getId());

		}

		try {
			clienteService.guardarFactura(factura);

		} catch (Exception e) {
			flash.addFlashAttribute("error", "Error en crear factura");
			return "redirect:/home/homeventa/consultacliente";
		}

		status.setComplete();
		flash.addFlashAttribute("success", "Factura creada con exito");
		return "redirect:/home/homeventa/consultacliente";
	}

}
