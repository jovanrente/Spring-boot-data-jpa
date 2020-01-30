package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;


@Data
@Entity
@Table(name="facturas")
public class Factura implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	
	private String observacion;
	
	@Column(name="create_at")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private LocalDate createAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente; 
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="factura_id")
	private List<ItemFactura> items;
	
	
	public Factura() {
		this.items =  new ArrayList<ItemFactura>();
	}
	
	@PrePersist
	public void prePersist() {
		createAt = LocalDate.now();
	}
	
	public void addItemFactura(ItemFactura item) {
		items.add(item);
	}
	
	public Double getTotal() {
		return items.stream().mapToDouble(ItemFactura::calcularImporte).sum();
		
	}
	
	
	

}
