package co.edu.uco.pch.entity;

import java.util.UUID;

public class DepartamentoEntity { 
	private PaisEntity pais;
	private UUID id;
	private String nombre;
	
	public DepartamentoEntity() {
		super();
	}
	
	public DepartamentoEntity(final PaisEntity pais,final UUID id,final String nombre) {
		setPais(pais);
		setId(id);
		setNombre(nombre);
	}
	
	public static final DepartamentoEntity build() {
		return new DepartamentoEntity();
	}
	
	public PaisEntity getPais() {
		return pais;
	}
	public DepartamentoEntity setPais(final PaisEntity pais) {
		this.pais = pais;
		return this;
	}
	public UUID getId() {
		return id;
	}
	public DepartamentoEntity setId(final UUID id) {
		this.id = id;
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public DepartamentoEntity setNombre( final String nombre) {
		this.nombre = nombre;
		return this;
	}
	

}
