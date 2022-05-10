package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Encargado;

public class DaoEncargado extends Conexion implements BaseDAO<Encargado> {

	/*
	 * TABLA encargado
	 * 
	 * id_encargado | email_enc | contra_enc 
	 */

	Connection cnx = null;
	PreparedStatement stm = null;

	@Override
	public List<Encargado> listar() {

		List<Encargado> lst = new ArrayList<Encargado>();
		Encargado enc = null;

		String sql = "select * from encargado";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				enc = new Encargado();
				enc.setIdEncargado(rs.getString(1));
				enc.setEmail(rs.getString(2));
				enc.setContrasena(rs.getString(3));
				
				lst.add(enc);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

	}

	@Override
	public int insertar(Encargado enc) {
		String sql = "insert into encargado(id_encargado, email_enc, contra_enc) values (?, ?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, enc.getIdEncargado());
			stm.setString(2, enc.getEmail());
			stm.setString(3, enc.getContrasena());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Encargado enc) {
		String sql = "update encargado set email_enc=?, contra_enc=? where id_encargado=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);	// no se va a ejecutar directamente, necesita el commit
			stm = cnx.prepareStatement(sql);
			stm.setString(1, enc.getEmail());
			stm.setString(2, enc.getContrasena());
			stm.setString(3, enc.getIdEncargado());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int eliminar(int id) {		return 0;	}
}
