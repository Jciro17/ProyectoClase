package co.edu.uco.pch.entity;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public class CiudadEntity {
	private DepartamentoEntity departamento;
	private UUID id;
	private String nombre;
	
	public CiudadEntity() {
		super();
	}
	
	public CiudadEntity(final PaisEntity pais,final UUID id,final String nombre) {
		setDepartamento(departamento);
		setId(id);
		setNombre(nombre);
	}
	
	public static final CiudadEntity build() {
		return new CiudadEntity();
	}
	
	public DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public CiudadEntity setDepartamento(final DepartamentoEntity departamento) {
		this.departamento = departamento;
		return this;
	}
	public UUID getId() {
		return id;
	}
	public CiudadEntity setId(final UUID id) {
		this.id = id;
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public CiudadEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);;
		return this;
	}

}
