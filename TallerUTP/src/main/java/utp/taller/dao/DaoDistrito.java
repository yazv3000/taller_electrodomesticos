package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Distrito;

public class DaoDistrito extends Conexion {

	Connection cnx = null;
	PreparedStatement stm = null;

	public List<Distrito> listar() {

		List<Distrito> lst = new ArrayList<Distrito>();
		Distrito distr;
		
		String sql = "select * from distrito";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				distr = new Distrito();
				distr.setIdDistrito(rs.getInt("id_distrito"));
				distr.setNombreDistrito(rs.getString("nombre_distrito"));
				lst.add(distr);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}
	
}
