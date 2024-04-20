package co.edu.uco.pch.dto;

import java.util.UUID;

public class CiudadDTO {
	private DepartamentoDTO departamento;
	private UUID id;
	private String nombre;
	
	public CiudadDTO() {
		super();
	}
	
	public CiudadDTO(final PaisDTO pais,final UUID id,final String nombre) {
		setDepartamento(departamento);
		setId(id);
		setNombre(nombre);
	}
	
	public static final CiudadDTO build() {
		return new CiudadDTO();
	}
	
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public CiudadDTO setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = departamento;
		return this;
	}
	public UUID getId() {
		return id;
	}
	public CiudadDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public CiudadDTO setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

}