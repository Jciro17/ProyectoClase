package co.edu.uco.pch.dto;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public class DepartamentoDTO { 
	private PaisDTO pais;
	private UUID id;
	private String nombre;
	
	public DepartamentoDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setPais(PaisDTO.build());
	}
	
	public DepartamentoDTO(final PaisDTO pais,final UUID id,final String nombre) {
		setPais(pais);
		setId(id);
		setNombre(nombre);
	}
	
	public static final DepartamentoDTO build() {
		return new DepartamentoDTO();
	}
	
	public PaisDTO getPais() {
		return pais;
	}
	public DepartamentoDTO setPais(final PaisDTO pais) {
		this.pais = pais;
		return this;
	}
	public UUID getId() {
		return id;
	}
	public DepartamentoDTO setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public DepartamentoDTO setNombre( final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	

}
