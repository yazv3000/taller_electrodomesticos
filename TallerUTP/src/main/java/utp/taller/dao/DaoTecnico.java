package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Tecnico;

public class DaoTecnico extends Conexion implements CRUD<Tecnico> {

	Connection cnx = null;
	PreparedStatement stm = null;
	
	public DtoUsuario validar(String email, String contra) {
		DtoUsuario dtoTec= new DtoUsuario();
		String sql = "select * from f_validar_acceso(3,?,?)";
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, contra);
			rs = stm.executeQuery();
			if (rs.next()) {
				dtoTec.setIdPersona(rs.getInt("id_persona"));
				dtoTec.setUsername(rs.getString("id_user"));
				dtoTec.setRol(rs.getString("nombre_completo"));
				dtoTec.setEmail(rs.getString("correo"));
				dtoTec.setProfilePic(rs.getBytes("foto"));
				dtoTec.setUsername(sql);
			}
			cnx.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dtoTec;
	}
	
	public List<DtoTecnicoConsulta> listarDtoTecnicos(){
		List<DtoTecnicoConsulta> lst = new ArrayList<DtoTecnicoConsulta>();
		DtoTecnicoConsulta tec = null;
		String sql = "select * from v_tecnicos";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				tec = new DtoTecnicoConsulta();
				tec.setIdPersonaTecnico(rs.getInt("id_persona"));
				tec.setIdUsuarioTecnico(rs.getString("id_user"));
				tec.setNombreCompleto(rs.getString("nombres"));
				tec.setEspecialidad(rs.getString("especialidad"));
				tec.setTelefono(rs.getString("telefono"));
				tec.setDistrito(rs.getString("nombre_distrito"));		
				tec.setDireccion(rs.getString("direccion"));
				tec.setEmail(rs.getString("email"));
				tec.setEstadoActivo(rs.getBoolean("estado_activ"));
				lst.add(tec);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

	}

	@Override
	public Tecnico consultarId(int idTecnico) {

		Tecnico tec = null;

		String sql = "select * from f_consultar_tecnico(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idTecnico);
			rs = stm.executeQuery();

			if (rs.next()) {
				tec = new Tecnico();
				tec.setIdPersonaTecnico(rs.getInt(1));
				tec.setIdUsuarioTecnico(rs.getString(2));
				tec.setNombrePrin(rs.getString(3));
				tec.setNombreSec(rs.getString(4));
				tec.setApePrin(rs.getString(5));
				tec.setApeSec(rs.getString(6));
				tec.setTipoDocumento(rs.getInt(7));
				tec.setNroDocumento(rs.getString(8));
				tec.setIdEspecialidad(rs.getInt(9));
				tec.setAniosExperiencia(rs.getInt(10));
				tec.setTelefono(rs.getString(11));
				tec.setIdDistrito(rs.getInt(12));
				tec.setDireccion(rs.getString(13));
				tec.setEmail(rs.getString(14));
				tec.setContrasena(rs.getString(15));
				tec.setFoto(rs.getBytes(16));
				tec.setEstadoActivo(rs.getBoolean(17));
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tec;
	}

	@Override
	public int insertar(Tecnico tec) {
		String sql = "call sp_nuevo_tecnico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, tec.getNombrePrin());
			stm.setString(2, tec.getNombreSec());
			stm.setString(3, tec.getApePrin());
			stm.setString(4, tec.getApeSec());
			stm.setInt(5, tec.getTipoDocumento());
			stm.setString(6, tec.getNroDocumento());
			stm.setString(7, tec.getTelefono());
			stm.setInt(8, tec.getIdDistrito());
			stm.setString(9, tec.getDireccion());
			stm.setString(10, tec.getEmail());
			//stm.setString(11, tec.getContrasena());
			stm.setString(11, "por defecto");
			stm.setInt(12, tec.getIdEspecialidad());
			stm.setInt(13, tec.getAniosExperiencia());
			stm.setObject(14, LocalDate.now());
			stm.setBytes(15, tec.getFoto());
			
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Tecnico tec) {
		String sql = "call sp_actualizar_tecnico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, tec.getIdPersonaTecnico());
			stm.setString(2, tec.getIdUsuarioTecnico());
			stm.setString(3, tec.getNombrePrin());
			stm.setString(4, tec.getNombreSec());
			stm.setString(5, tec.getApePrin());
			stm.setString(6, tec.getApeSec());
			stm.setInt(7, tec.getTipoDocumento());
			stm.setString(8, tec.getNroDocumento());
			stm.setString(9, tec.getTelefono());
			stm.setInt(10, tec.getIdDistrito());
			stm.setString(11, tec.getDireccion());
			stm.setString(12, tec.getEmail());
			stm.setString(13, tec.getContrasena());
			stm.setInt(14, tec.getIdEspecialidad());
			stm.setInt(15, tec.getAniosExperiencia());
			stm.setObject(16, LocalDate.now());
			stm.setObject(17, null);
			stm.setBoolean(18, tec.isEstadoActivo());
			stm.setBytes(19, tec.getFoto());

			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int desactivar(int id) {
		
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
