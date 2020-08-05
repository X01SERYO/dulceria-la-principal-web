package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dulcerialaprincipal.web.app.models.entity.Factura;

@Repository
public class FacturaDaoImplement implements IFacturaDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void guardarFactura(Factura factura) {
		if (factura.getIdVenta() != null) {
			em.merge(factura);
		} else {
			em.persist(factura);
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Factura").getResultList();
	}

}
