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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="create_at")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private LocalDate createAt;
	
	@Column(name="foto")
	private String foto;
	
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;	
	
	public void addFactura(Factura factura) {
		facturas.add(factura);
	}
	/*@PrePersist
	public void prePersist() {
		createAt = LocalDate.now();
	}*/
	
}
