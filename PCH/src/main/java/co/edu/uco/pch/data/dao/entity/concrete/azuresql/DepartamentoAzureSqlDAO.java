package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConecction;
import co.edu.uco.pch.entity.DepartamentoEntity;

public class DepartamentoAzureSqlDAO extends SqlConecction implements DepartamentoDAO {
	
	public DepartamentoAzureSqlDAO (final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<DepartamentoEntity> consultar(DepartamentoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
