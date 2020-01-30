package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Double precio; 
	
	@Column(name="create_at")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private LocalDate createAt;
	
	
	@PrePersist
	public void prePersist() {
		createAt = LocalDate.now();
	}

}
