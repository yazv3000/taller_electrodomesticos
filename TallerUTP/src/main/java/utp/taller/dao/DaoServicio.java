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

	Connection cnx = null;
	PreparedStatement stm = null;

	@Override
	public Servicio consultarId(int id) {
		Servicio serv = new Servicio();
		
		String sql = "select * from servicio where id_servicio=?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			if (rs.next()) {
				serv = recuperarDatosServicio(rs);
			}
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return serv;
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
			//stm.setInt(3, s.getIdServicio());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int cambiarEstado(int id, boolean estado) {
		
		return 0;
	}
	
	// LISTAR SERVICIOS
	public List<Servicio> listar() {

		List<Servicio> lst = new ArrayList<Servicio>();
		Servicio serv = null;
		String sql = "select * from servicio";

		cnx = getConnection();
		ResultSet rs = null;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				serv = recuperarDatosServicio(rs);
				lst.add(serv);
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public List<Servicio> listar(boolean estado){
		List<Servicio> lst = new ArrayList<Servicio>();
		Servicio serv = null;
		String sql = "select * from servicio where estado_activ=?";

		cnx = getConnection();
		ResultSet rs = null;
		try {
			stm = cnx.prepareStatement(sql);
			stm.setBoolean(1, estado);
			rs = stm.executeQuery();

			while (rs.next()) {
				serv = recuperarDatosServicio(rs);
				lst.add(serv);
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	private Servicio recuperarDatosServicio(ResultSet rs ) {
		Servicio serv = new Servicio();
		try {
			serv.setIdServicio(rs.getInt("id_servicio"));
			serv.setNomServicio(rs.getString("nombre_pl"));
			serv.setDescripcion(rs.getString("descripcion"));
			serv.setEstadoActivo(rs.getBoolean("estado_activ"));
			serv.setRutaImgServicio(rs.getString("foto_serv"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serv;
	}
}
