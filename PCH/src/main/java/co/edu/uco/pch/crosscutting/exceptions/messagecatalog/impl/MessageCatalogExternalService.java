package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;

public class MessageCatalogExternalService implements MessageCatalog {

	@Override
	public final void inicializar() {		
	}

	@Override
	public final String obtenerContendidoMensaje(final CodigoMensaje codigo, String... parametros) {
		return null;
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros) {
		return null;
	}

	@Override
	public String obtenerContenidoMensaje(String identificador, String... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

}