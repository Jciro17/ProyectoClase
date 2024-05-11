package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.crosscutting.exceptions.custom.DataPCHException;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConecction;
import co.edu.uco.pch.entity.CiudadEntity;

public final class CiudadAzureSqlDAO extends SqlConecction implements CiudadDAO {

	public CiudadAzureSqlDAO(final Connection conexion) {
		super(conexion);
	}
	

	@Override
	public final void crear(CiudadEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder ();
		
		sentenciaSql.append("INSERT INTO Ciudad (id, nombre, departamento) ");
		sentenciaSql.append("SELECT ?,?,?");
		
		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())){
			
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());
			
			sentenciaSqlPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"${1}\".Por favor intente de nuevo y si el problema persiste contacte con el administrador...";
			var mensajeTecnico = "Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL. Para mas detalles, revise de forma completa la excepcion raiz presentada..";
			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"${1}\".Por favor intente de nuevo y si el problema persiste contacte con el administrador...";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO de tipo Exception tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL. Para mas detalles, revise de forma completa la excepcion raiz presentada..";
			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		}	
		
		
		
	}

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void modificar(CiudadEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}