package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.UUID;

import co.edu.uco.pch.business.assembler.entity.impl.DepartamentoAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.pch.crosscutting.exceptions.custom.BusinessPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;

public final class RegistrarCiudad implements UseCaseWithoutReturn<CiudadDomain> {

    private DAOFactory factory;

    public RegistrarCiudad(final DAOFactory factory){
        if(ObjectHelper.getObjectHelper().isNull(factory)){
			var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030);
            throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final CiudadDomain data) {
        // 1. Validar que los casos de uso sean correctos a nivel de tipo de dato, longitutd, obligateriodidad, formato, rango, etc...
        // 2. Validar que no exista otra ciudad con el mismo nombre para el mismo departamento
        validarCiudadMismoNombreMismoDepartamento(data.getNombre(), data.getDepartamento().getId());

        // 3. Validar que no exista otra ciudad con el mismo identificador
        var ciudadEntity = CiudadEntity.build().setId(generarIdentificadorCiudad())
        		.setNombre(data.getNombre()).setDepartamento(DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));
        // 4. Guardar la nueva ciudad	

        factory.getCiudadDAO().crear(ciudadEntity);
    }

    private final UUID generarIdentificadorCiudad(){
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while(existeId){
            id = UUIDHelper.generate();
            var ciudadEntity = CiudadEntity.build().setId(id);
            var resultados = factory.getCiudadDAO().consultar(ciudadEntity);

            existeId = !resultados.isEmpty();
        }
        return id;
    }

    private final void validarCiudadMismoNombreMismoDepartamento(final String nombreCiudad, final UUID idDepartamento){
        var ciudadEntity = CiudadEntity.build().setNombre(nombreCiudad).
                setDepartamento(DepartamentoEntity.build().setId(idDepartamento));
        var resultados = factory.getCiudadDAO().consultar(ciudadEntity);

        if (!resultados.isEmpty()){
        	var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
            throw new BusinessPCHException(mensajeUsuario);

        }
    }
}