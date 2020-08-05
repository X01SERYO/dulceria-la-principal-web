package com.dulcerialaprincipal.web.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_factura")
public class ItemFactura {

	@Id
	@Column(name = "idventa_producto")
	@NotNull
	private Integer id;

	private Integer cantidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_codigo")
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venta_idventa")
	private Factura factura;
	private Double total;

	public ItemFactura() {
		super();
	}

	public ItemFactura(@NotNull Integer id, Integer cantidad, Producto producto, Factura factura, Double total) {
		super();
		this.id = id;
		this.cantidad = 0;
		this.producto = producto;
		this.factura = factura;
		this.total = 0.0;
	}

	public Integer getId() {
		return id;
	}
	

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double calcularImporte() {
		return cantidad.doubleValue() * producto.getPrecio();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
