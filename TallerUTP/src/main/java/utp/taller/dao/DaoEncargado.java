package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoEncargadoConsulta;
import utp.taller.entidades.Encargado;

public class DaoEncargado extends Conexion implements BaseDAO<Encargado> {

	Connection cnx = null;
	PreparedStatement stm = null;
	
	public DtoEncargadoConsulta validar(String email, String contra) {
		DtoEncargadoConsulta dtoEnc = new DtoEncargadoConsulta();
		String sql = "select * from f_validar_acceso(?,?,?)";
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, 2);
			stm.setString(2, email);
			stm.setString(3, contra);
			rs = stm.executeQuery();
			if (rs.next()) {
				dtoEnc.setEmail(rs.getString(5));
				System.out.println("llegue a qui");
				//dtoClie.setContra(rs.getString("contra"));
			}
			cnx.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return dtoEnc;
	}
	
	@Override
	public Encargado consultarId(int id) {
		return null;
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
