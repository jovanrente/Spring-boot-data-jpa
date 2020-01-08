package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	/*@PrePersist
	public void prePersist() {
		createAt = LocalDate.now();
	}*/
	
}
