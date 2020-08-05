package com.dulcerialaprincipal.web.app.models.dao;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dulcerialaprincipal.web.app.models.entity.Cliente;

@Repository
public class ClienteDaoImplement implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarId(Integer idcliente) {
		// TODO Auto-generated method stub
		return em.createQuery("FROM Cliente WHERE idcliente ="+idcliente).getResultList();
	}

	@Override
	public Cliente buscarUnCliente(Integer idcliente) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, idcliente);
	}

	@Override
	public void registrarClientes(Cliente cliente) {
		// TODO Auto-generated method stub
		em.persist(cliente);
	}

	@Override
	public Cliente editarCliente(Integer idcliente) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, idcliente);
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if (cliente.getIdcliente() != null) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

}
