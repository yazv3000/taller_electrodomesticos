package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Especialidad;

public class DaoEspecialidad extends Conexion {

	Connection cnx = null;
	PreparedStatement stm = null;

	public List<Especialidad> listar() {

		List<Especialidad> lst = new ArrayList<Especialidad>();
		Especialidad esp = null;

		String sql = "select * from v_especialidades";

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
}
