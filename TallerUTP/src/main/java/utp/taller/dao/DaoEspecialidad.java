package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Especialidad;

public class DaoEspecialidad extends Conexion implements BaseDAO<Especialidad> {

	/*
	 * TABLA ESPECIALIDAD
	 * 
	 * id_servicio | nom_serv | desc_serv
	 */

	Connection cnx = null;
	PreparedStatement stm = null;

	@Override
	public List<Especialidad> listar() {

		List<Especialidad> lst = new ArrayList<Especialidad>();
		Especialidad esp = null;

		String sql = "select * from especialidad";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				esp = new Especialidad();
				esp.setIdEspecialidad(rs.getInt(1));
				esp.setNomEsp(rs.getString(2));

				lst.add(esp);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;

	}

	@Override
	public int insertar(Especialidad esp) {		return 0;	}

	@Override
	public int modificar(Especialidad esp) {		return 0;	}

	@Override
	public int eliminar(int id) {		return 0;	}
	
	
}
