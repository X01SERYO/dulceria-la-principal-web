package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dulcerialaprincipal.web.app.models.entity.ItemFactura;

@Repository
public class ItemFacturaImplement implements IItemFacturaDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<ItemFactura> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from ItemFactura").getResultList();
	}

	/*@Override
	public void guardarItemFactura(ItemFactura itemFactura) {
		if (itemFactura.getId() != null) {
			em.merge(itemFactura);
		} else {
			em.persist(itemFactura);
		}
		
	}*/

}
