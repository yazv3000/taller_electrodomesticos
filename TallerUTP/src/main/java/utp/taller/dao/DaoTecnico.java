package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.dto.DtoTecnicoNombre;
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
				dtoTec.setIdPersona(rs.getInt(1));
				dtoTec.setIdUsuario(rs.getString(2));
				dtoTec.setRol(rs.getString(3));
				dtoTec.setUsername(rs.getString(4));
				dtoTec.setEmail(rs.getString(5));
				dtoTec.setProfilePic(rs.getString(6));
			}
			cnx.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dtoTec;
	}
	
	// OPERACIONES CRUD
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
				String strArrayIds = rs.getString(9);
				strArrayIds = strArrayIds.replace("\"", "");
				if (strArrayIds.contains("NULL") || strArrayIds.contains("null") || strArrayIds==null) {
					tec.setIdsEspecialidad(null);
				}else {
					String[] strIdsEsp = strArrayIds.substring(strArrayIds.indexOf("{")+1, strArrayIds.indexOf("}")).split(",");
					tec.setIdsEspecialidad(Arrays.stream(strIdsEsp).mapToInt(Integer::parseInt).toArray());
				}
				tec.setAniosExperiencia(rs.getInt(10));
				tec.setTelefono(rs.getString(11));
				tec.setIdDistrito(rs.getInt(12));
				tec.setDireccion(rs.getString(13));
				tec.setEmail(rs.getString(14));
				tec.setContrasena(rs.getString(15));
				tec.setRutaFoto(rs.getString(16));
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
			stm.setString(11, tec.getContrasena());
			stm.setInt(12, tec.getAniosExperiencia());
			stm.setObject(13, LocalDate.now());
			stm.setString(14, tec.getRutaFoto());
			
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Tecnico tec) {
		String sql = "call sp_actualizar_tecnico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			stm.setInt(14, tec.getAniosExperiencia());
			stm.setObject(15, LocalDate.now());
			stm.setObject(16, null);
			stm.setBoolean(17, tec.isEstadoActivo());
			stm.setString(18, tec.getRutaFoto());

			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int cambiarEstado(int id, boolean estado) {
		
		String sql = "call sp_cambiar_estado_persona(?, ?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, id);
			stm.setBoolean(2, estado);
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	// LISTA DE T?CNICOS PARA MOSTRAR EN LA TABLA DE MANTENIMIENTO
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
				tec = recuperarDatosDto(rs);
				lst.add(tec);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

	}

	public List<DtoTecnicoConsulta> listarDtoTecnicos(boolean estado) {
		
		List<DtoTecnicoConsulta> lst = new ArrayList<DtoTecnicoConsulta>();
		DtoTecnicoConsulta tec = null;
		String sql = "select * from v_tecnicos where estado_activ = ?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setBoolean(1, estado);
			rs = stm.executeQuery();

			while (rs.next()) {
				tec = recuperarDatosDto(rs);
				lst.add(tec);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public List<DtoTecnicoConsulta> listarDtoTecnicos(String especialidad) {
		
		List<DtoTecnicoConsulta> lst = new ArrayList<DtoTecnicoConsulta>();
		DtoTecnicoConsulta tec = null;
		String sql = "select * from v_tecnicos where estado_activ and especialidad like ?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, "%"+especialidad+"%");
			rs = stm.executeQuery();

			while (rs.next()) {
				tec = recuperarDatosDto(rs);
				lst.add(tec);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public DtoTecnicoConsulta consultarDtoNombres(String nombreTecnico) {
		DtoTecnicoConsulta tec = new DtoTecnicoConsulta();

		String sql = "select * from v_tecnicos where upper(nombres) like ?";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, "%"+nombreTecnico.toUpperCase()+"%");
			rs = stm.executeQuery();
			if (rs.next()) {
				tec = recuperarDatosDto(rs);
			}
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tec;
	}

	// M?TODOS PRIVADOS
	private DtoTecnicoConsulta recuperarDatosDto(ResultSet rs ) {
		DtoTecnicoConsulta tec = new DtoTecnicoConsulta();
		try {
				tec.setIdPersonaTecnico(rs.getInt("id_persona"));
				tec.setIdUsuarioTecnico(rs.getString("id_user"));
				tec.setNombreCompleto(rs.getString("nombres"));
				tec.setEspecialidad(rs.getString("especialidad"));
				tec.setTelefono(rs.getString("telefono"));
				tec.setDistrito(rs.getString("nombre_distrito"));			
				tec.setDireccion(rs.getString("direccion"));
				tec.setEmail(rs.getString("email"));
				tec.setRutaFoto(rs.getString("foto"));
				tec.setEstadoActivo(rs.getBoolean("estado_activ"));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tec;
	}
	
	// LISTAR TECNICOS CON HORARIO 
		public List<DtoTecnicoNombre> listarTecnicoConHorario  (int mes, int anyo){
			String sql ="select * from f_tecnicos_con_horario(?,?) ";
			List<DtoTecnicoNombre> lst = new ArrayList<DtoTecnicoNombre>();
			cnx = getConnection();
			try {
				stm = cnx.prepareStatement(sql);
				stm.setInt(1, mes);
				stm.setInt(2, anyo);
				ResultSet rs = null;
				rs = stm.executeQuery();

				while (rs.next()) {
					DtoTecnicoNombre dtoTec = new DtoTecnicoNombre();
					dtoTec.setId(rs.getInt(1));
					dtoTec.setNombre(rs.getString(2));
					lst.add(dtoTec);
				}	
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
		//FALTA VER SI FINCIONA SIN ESTE
		// LISTAR TECNICOS SIN HORARIO 	
		public List<DtoTecnicoNombre> listarTecnicoSinHorario (){
	
			String sql ="select id_persona, nombres from v_tecnicos";
			List<DtoTecnicoNombre> lst = new ArrayList<DtoTecnicoNombre>();
			cnx = getConnection();
			try {
				stm = cnx.prepareStatement(sql);
				ResultSet rs = null;
				rs = stm.executeQuery();

				while (rs.next()) {
					DtoTecnicoNombre dtoTec = new DtoTecnicoNombre();
					dtoTec.setId(rs.getInt(1));
					dtoTec.setNombre(rs.getString(2));
					lst.add(dtoTec);
				}	
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
		// LISTAR TECNICOS SIN HORARIO 	
		public List<DtoTecnicoNombre> listarTecnicos(){
	
			String sql ="select id_persona, nombres from v_tecnicos";
			List<DtoTecnicoNombre> lst = new ArrayList<DtoTecnicoNombre>();
			cnx = getConnection();
			try {
				stm = cnx.prepareStatement(sql);

				ResultSet rs = null;
				rs = stm.executeQuery();

				while (rs.next()) {
					DtoTecnicoNombre dtoTec = new DtoTecnicoNombre();
					dtoTec.setId(rs.getInt(1));
					dtoTec.setNombre(rs.getString(2));
					lst.add(dtoTec);
				}	
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
}
