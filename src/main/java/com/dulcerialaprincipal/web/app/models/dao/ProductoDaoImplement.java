package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.dulcerialaprincipal.web.app.models.entity.Producto;

@Repository
public class ProductoDaoImplement implements IProductoDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}

	@Override
	public void guardarProductos(Producto producto) {
		if (producto.getCodigo() != null) {
			em.merge(producto);
		} else {
			em.persist(producto);
		}

	}

	@Override
	public Producto editarProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return em.find(Producto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Producto> buscarId(Integer codigo) {
		// TODO Auto-generated method stub
		return em.createQuery("FROM Producto WHERE CONVERT(codigo ,CHAR(40)) LIKE '%" + codigo+"%'").getResultList();
	}

	@Override
	public void registrarProductos(Producto producto) {
		// TODO Auto-generated method stub
		em.persist(producto);
	}

}

