package com.dulcerialaprincipal.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dulcerialaprincipal.web.app.models.dao.IProductoDao;
import com.dulcerialaprincipal.web.app.models.entity.Producto;

@Service
public class ProductoServiceImplement implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoDao.findAll();
	}

	@Override
	@Transactional
	public void guardarProductos(Producto producto) {
		productoDao.guardarProductos(producto);		
	}

	@Override
	@Transactional
	public Producto editarProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return productoDao.editarProducto(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> buscarId(Integer codigo) {
		// TODO Auto-generated method stub
		return productoDao.buscarId(codigo);
	}

	@Override
	@Transactional
	public void registrarProductos(Producto producto) {
		// TODO Auto-generated method stub
		productoDao.registrarProductos(producto);
	}

	
}