package com.dulcerialaprincipal.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dulcerialaprincipal.web.app.models.dao.IClienteDao;
import com.dulcerialaprincipal.web.app.models.dao.IFacturaDao;
import com.dulcerialaprincipal.web.app.models.dao.IItemFacturaDao;
import com.dulcerialaprincipal.web.app.models.dao.IProductoDao;
import com.dulcerialaprincipal.web.app.models.entity.Cliente;
import com.dulcerialaprincipal.web.app.models.entity.Factura;
import com.dulcerialaprincipal.web.app.models.entity.ItemFactura;
import com.dulcerialaprincipal.web.app.models.entity.Producto;

@Service
public class ClienteServiceImplement implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private IFacturaDao facturaDao;

	@Autowired
	private IItemFacturaDao itemFacturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarId(Integer idcliente) {
		// TODO Auto-generated method stub
		return clienteDao.buscarId(idcliente);
	}

	@Override
	public Cliente buscarUnCliente(Integer idcliente) {
		// TODO Auto-generated method stub
		return clienteDao.buscarUnCliente(idcliente);
	}

	@Override
	@Transactional
	public void registrarClientes(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.registrarClientes(cliente);
	}

	@Override
	public Cliente editarCliente(Integer idcliente) {
		// TODO Auto-generated method stub
		return clienteDao.editarCliente(idcliente);
	}

	@Override
	@Transactional
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.guardarCliente(cliente);
	}

	@Override
	public Producto buscarIdProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return productoDao.editarProducto(codigo);
	}

	@Override
	@Transactional
	public void guardarFactura(Factura factura) {
		// TODO Auto-generated method stub
		try {
			facturaDao.guardarFactura(factura);
		} catch (Exception e) {
			System.out.println("Error en el metodo guardar Factura");
		}

	}

	@Override
	public List<Factura> findAllFacturas() {
		// TODO Auto-generated method stub
		return facturaDao.findAll();
	}

	@Override
	public List<ItemFactura> findAllItemFacturas() {
		// TODO Auto-generated method stub
		return itemFacturaDao.findAll();
	}

	/*
	 * @Override public void guardarItemFactura(ItemFactura itemFactura) { try {
	 * itemFacturaDao.guardarItemFactura(itemFactura); } catch (Exception e) {
	 * System.out.println("Error en el metodo guardar ItemFactura"); }
	 * 
	 * }
	 */

}
