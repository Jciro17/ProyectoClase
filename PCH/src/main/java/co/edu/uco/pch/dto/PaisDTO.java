package co.edu.uco.pch.dto;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public final class PaisDTO {
	
	private UUID id;
	private String nombre;
	
	
	
	
	public PaisDTO() {
		super();
	}
	
	public PaisDTO(final UUID id,final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final PaisDTO build() {
		return new PaisDTO();
	}
	
	public UUID getId() {
		return id;
	}
	public PaisDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public PaisDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	
	
}