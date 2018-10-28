package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Salon
 *
 */
@Entity
@Table(name = "SALONES")
public class Salon implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable=false,length=40,unique=true)
	private String nombre;
	private int capacidadMax;
	@Column(nullable=false)
	private boolean practicas;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	public enum Tipo{
		Laborario,
		Comun,
		Examen
	}
	
	@ManyToOne(optional=false,cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Area area;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
	private List<Material> materiales;
	
	public Salon() {
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

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public boolean isPracticas() {
		return practicas;
	}

	public void setPracticas(boolean practicas) {
		this.practicas = practicas;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
   
}
