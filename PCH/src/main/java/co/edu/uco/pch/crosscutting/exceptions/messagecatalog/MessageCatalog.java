package co.edu.uco.pch.crosscutting.exceptions.messagecatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;

public interface MessageCatalog {
	
	void inicializar();
	
	String obtenerContenidoMensaje(final String identificador, String... parametros);
	
	Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros);

	String obtenerContendidoMensaje(final CodigoMensaje codigo, String... parametros);

}
