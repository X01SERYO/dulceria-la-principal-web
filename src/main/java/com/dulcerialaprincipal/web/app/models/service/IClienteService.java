package com.dulcerialaprincipal.web.app.models.service;

import java.util.List;

import com.dulcerialaprincipal.web.app.models.entity.Cliente;
import com.dulcerialaprincipal.web.app.models.entity.Factura;
import com.dulcerialaprincipal.web.app.models.entity.ItemFactura;
import com.dulcerialaprincipal.web.app.models.entity.Producto;

public interface IClienteService {

	public List<Cliente> findAll();

	public List<Cliente> buscarId(Integer idcliente);

	public Cliente buscarUnCliente(Integer idcliente);

	public void registrarClientes(Cliente cliente);

	public Cliente editarCliente(Integer idcliente);

	public void guardarCliente(Cliente idcliente);
	
	public Producto  buscarIdProducto(Integer codigo);
	
	public void guardarFactura(Factura factura);
	
	//public void guardarItemFactura(ItemFactura itemFactura);
	
	public List<Factura> findAllFacturas();
	
	public List<ItemFactura> findAllItemFacturas();
}
