package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Servicio;

public class DaoServicio extends Conexion implements CRUD<Servicio> {

	/*
	 * TABLA SERVICIO
	 * 
	 * id_servicio | nom_serv | desc_serv
	 */

	Connection cnx = null;
	PreparedStatement stm = null;


	public List<Servicio> listar() {

		List<Servicio> lst = new ArrayList<Servicio>();
		Servicio s = null;

		String sql = "select * from servicio";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				s = new Servicio();
				s.setIdServicio(rs.getInt(1));
				s.setNomServicio(rs.getString(2));
				s.setDescripcion(rs.getString(3));

				lst.add(s);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}/* finally {
			 try { if(rs != null) rs.close(); if(stm != null) stm.close(); if(cnx != null)
			 cnx.close(); } catch (Exception e2){}	 
		}*/
		return lst;

	}
	
	@Override
	public Servicio consultarId(int id) {
		return null;
	}

	@Override
	public int insertar(Servicio s) {
		String sql = "insert into servicio(nom_serv, desc_serv) values (?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);	// no se va a ejecutar directamente, necesita el commit
			stm = cnx.prepareStatement(sql);
			stm.setString(1, s.getNomServicio());
			stm.setString(2, s.getDescripcion());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Servicio s) {
		String sql = "update servicio set nom_serv=?, desc_serv=? where id_servicio=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, s.getNomServicio());
			stm.setString(2, s.getDescripcion());
			stm.setInt(3, s.getIdServicio());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int cambiarEstado(int id) {
		
		String sql = "delete from servicio where id_servicio=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
}
