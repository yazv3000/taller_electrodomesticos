package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Tecnico;

public class DaoTecnico extends Conexion implements BaseDAO<Tecnico> {

	/*
	 * TABLA tecnico
	 * 
	 * id_tecnico | nom_tec | ape1_tec | ape2_tec | id_tdoc | nro_doc | direccion | experiencia | email_tec | contra_tec  
	 */

	Connection cnx = null;
	PreparedStatement stm = null;

	@Override
	public List<Tecnico> listar() {

		List<Tecnico> lst = new ArrayList<Tecnico>();
		Tecnico t = null;

		String sql = "select * from tecnico";	// inner join ....

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				t = new Tecnico();
				t.setIdTecnico(rs.getInt(1));
				t.setNombre(rs.getString(2));
				t.setApePrin(rs.getString(3));
				t.setApeSec(rs.getString(4));
				// 5 - tipo de documento
				t.setNro_doc(rs.getString(6));
				t.setDireccion(rs.getString(7));
				t.setAnios_experiencia(rs.getInt(8));
				t.setEmail(rs.getString(9));
				t.setContrasena(rs.getString(10));
				
				lst.add(t);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

	}

	@Override
	public int insertar(Tecnico t) {
		String sql = "insert into tecnico(nom_tec, ape1_tec, ape2_tec, id_tdoc, nro_doc, direccion, experiencia, email_tec, contra_tec) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, t.getNombre());
			stm.setString(2, t.getApePrin());
			stm.setString(3, t.getApeSec());
			stm.setInt(4, 1);		// 1 = dni
			stm.setString(5, t.getNro_doc());
			stm.setString(6, t.getDireccion());
			stm.setInt(7, t.getAnios_experiencia());
			stm.setString(8, t.getEmail());
			stm.setString(9, t.getContrasena());
			
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Tecnico t) {
		String sql = "update tecnico set nom_tec=?, ape1_tec=?, ape2_tec=?, id_tdoc=?, nro_doc=?, direccion=?, experiencia=?, email_tec=?, contra_tec=? where id_tecnico=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, t.getNombre());
			stm.setString(2, t.getApePrin());
			stm.setString(3, t.getApeSec());
			stm.setInt(4, 1);		// 1 = dni
			stm.setString(5, t.getNro_doc());
			stm.setString(6, t.getDireccion());
			stm.setInt(7, t.getAnios_experiencia());
			stm.setString(8, t.getEmail());
			stm.setString(9, t.getContrasena());
			stm.setInt(10, t.getIdTecnico());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int eliminar(int id) {
		
		String sql = "delete from tecnico where id_tecnico=?";
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
