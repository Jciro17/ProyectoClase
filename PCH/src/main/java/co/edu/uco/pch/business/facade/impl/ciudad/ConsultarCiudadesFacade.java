package co.edu.uco.pch.business.facade.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.ConsultarCiudades;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.custom.BusinessPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

public final class ConsultarCiudadesFacade implements FacadeWithReturn <CiudadDTO, List<CiudadDTO>> {


    private DAOFactory daoFactory;
    public ConsultarCiudadesFacade(){
         
     }
    
    @Override
    public final List<CiudadDTO> execute(final CiudadDTO dto) {
        daoFactory.iniciarTransaccion();
        try{

            var useCase = new ConsultarCiudades(daoFactory);
            var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = useCase.excecute(ciudadDomain);
            
            return CiudadAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);
            
        }catch (final PCHException exception){
            
            throw exception;
        }catch (final Exception exception){
            
            var mensajeUsuario = "Se ha presentado un porblema tratando de consultar la infomacion de la ciudad";
            var mensajeTecnico = "Se ha presentado un porblema inesperado tratando de consultar la informacion de las ciudadees";

            throw new BusinessPCHException(mensajeTecnico, mensajeUsuario, exception);
            
        }finally {
            daoFactory.cerrarConexion();
        }
    }
}
	
	


