package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;


import com.dulcerialaprincipal.web.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();

	public List<Cliente> buscarId(Integer idcliente);

	public Cliente buscarUnCliente(Integer idcliente);

	public void registrarClientes(Cliente cliente);
	
	public Cliente editarCliente(Integer idcliente);
	
	public void guardarCliente(Cliente cliente);
}
