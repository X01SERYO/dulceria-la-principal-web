package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;

import com.dulcerialaprincipal.web.app.models.entity.ItemFactura;

public interface IItemFacturaDao {

	public List<ItemFactura> findAll();

	//public void guardarItemFactura(ItemFactura itemFactura);
}
