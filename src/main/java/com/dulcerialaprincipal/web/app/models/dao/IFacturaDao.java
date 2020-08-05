package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;

import com.dulcerialaprincipal.web.app.models.entity.Factura;

public interface IFacturaDao {

	public void guardarFactura(Factura factura);
	
	public List<Factura> findAll();
}
