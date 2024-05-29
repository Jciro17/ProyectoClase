package co.edu.uco.pch.business.facade.impl.ciudad;

import co.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithoutReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.custom.BusinessPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

public class RegistrarCiudadFacade implements FacadeWithoutReturn<CiudadDTO> {
	
	private DAOFactory daoFactory;
	
	public RegistrarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void execute(final CiudadDTO dto) {
		
		daoFactory.iniciarTransaccion();
		
		try {
			var useCase = new RegistrarCiudad(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			useCase.execute(ciudadDomain);
			
			daoFactory.confirmarTransaccion();
		} catch (final PCHException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.iniciarTransaccion();
			
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00028);
			
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario, excepcion);
			
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
