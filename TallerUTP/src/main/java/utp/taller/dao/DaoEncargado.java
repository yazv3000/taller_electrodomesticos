package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import utp.config.Conexion;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Encargado;

public class DaoEncargado extends Conexion implements CRUD<Encargado> {

	Connection cnx = null;
	PreparedStatement stm = null;
	
	public DtoUsuario validar(String email, String contra) {
		DtoUsuario dtoEnc = new DtoUsuario();
		String sql = "select * from f_validar_acceso(2,?,?)";
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, contra);
			rs = stm.executeQuery();
			if (rs.next()) {
				dtoEnc.setIdPersona(rs.getInt("id_persona"));
				dtoEnc.setUsername(rs.getString("id_user"));
				dtoEnc.setRol(rs.getString("nombre_completo"));
				dtoEnc.setEmail(rs.getString("correo"));
				dtoEnc.setProfilePic(rs.getBytes("foto"));
				dtoEnc.setUsername(sql);
			}
			cnx.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dtoEnc;
	}
	
	
	@Override
	public Encargado consultarId(int idEncargado) {

		Encargado enc = null;

		String sql = "select * from f_consultar_encargado(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idEncargado);
			rs = stm.executeQuery();

			if (rs.next()) {
				enc = new Encargado();
				enc.setIdPersonaEncargado(rs.getInt(1));
				enc.setIdUsuarioEncargado(rs.getString(2));
				enc.setNombrePrin(rs.getString(3));
				enc.setNombreSec(rs.getString(4));
				enc.setApePrin(rs.getString(5));
				enc.setApeSec(rs.getString(6));
				enc.setTipoDocumento(rs.getInt(7));
				enc.setNroDocumento(rs.getString(8));
				enc.setTelefono(rs.getString(9));
				enc.setIdDistrito(rs.getInt(10));
				enc.setDireccion(rs.getString(11));
				enc.setEmail(rs.getString(12));
				enc.setContrasena(rs.getString(13));
				enc.setFoto(rs.getBytes(14));
				enc.setEstadoActivo(rs.getBoolean(15));
			}
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return enc;

	}

	@Override
	public int insertar(Encargado enc) {
		String sql = "call sp_nuevo_encargado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setString(1, enc.getNombrePrin());
			stm.setString(2, enc.getNombreSec());
			stm.setString(3, enc.getApePrin());
			stm.setString(4, enc.getApeSec());
			stm.setInt(5, enc.getTipoDocumento());
			stm.setString(6, enc.getNroDocumento());
			stm.setString(7, enc.getTelefono());
			stm.setInt(8, enc.getIdDistrito());
			stm.setString(9, enc.getDireccion());
			stm.setString(10, enc.getEmail());
			//stm.setString(11, enc.getContrasena());
			stm.setString(11, "por defecto");
			stm.setObject(12, LocalDate.now());
			stm.setBytes(13, enc.getFoto());
			
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Encargado enc) {
		String sql = "call sp_actualizar_encargado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, enc.getIdPersonaEncargado());
			stm.setString(2, enc.getIdUsuarioEncargado());
			stm.setString(3, enc.getNombrePrin());
			stm.setString(4, enc.getNombreSec());
			stm.setString(5, enc.getApePrin());
			stm.setString(6, enc.getApeSec());
			stm.setInt(7, enc.getTipoDocumento());
			stm.setString(8, enc.getNroDocumento());
			stm.setString(9, enc.getTelefono());
			stm.setInt(10, enc.getIdDistrito());
			stm.setString(11, enc.getDireccion());
			stm.setString(12, enc.getEmail());
			stm.setString(13, enc.getContrasena());
			stm.setObject(14, LocalDate.now());
			stm.setObject(15, null);
			stm.setBoolean(16, enc.isEstadoActivo());
			stm.setBytes(17, enc.getFoto());

			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int cambiarEstado(int id) {
		
		String sql = "call sp_desactivar_persona(?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, id);
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
}
