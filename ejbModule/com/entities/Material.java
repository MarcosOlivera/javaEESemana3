package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Material
 *
 */
@Entity
@Table(name = "MATERIALES")
public class Material implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable=false,length=40,unique = true)
	private String nombre;
	@Column(length=500)
	private String descripcion;
	
	@ManyToMany(mappedBy="materiales", fetch = FetchType.LAZY)
	private List<Salon> salones;
	
	public Material() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
   
}
