package com.dulcerialaprincipal.web.app.models.service;

import java.util.List;

import com.dulcerialaprincipal.web.app.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();

	public void guardarProductos(Producto producto);

	public Producto editarProducto(Integer codigo);

	public List<Producto> buscarId(Integer codigo);

	public void registrarProductos(Producto producto);
}
