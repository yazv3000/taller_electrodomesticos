package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoEspecialidad;

public class DaoEspecialidad extends Conexion {

	Connection cnx = null;
	PreparedStatement stm = null;

	public List<DtoEspecialidad> listar() {

		List<DtoEspecialidad> lst = new ArrayList<DtoEspecialidad>();
		DtoEspecialidad esp = null;

		String sql = "select * from v_especialidades";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				esp = new DtoEspecialidad();
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
	
	// ESPECIALIDADES POR TÉCNICO
	public List<DtoEspecialidad> listar(int idTecnico) {

		List<DtoEspecialidad> lst = new ArrayList<DtoEspecialidad>();
		DtoEspecialidad esp = null;

		String sql = "select * from f_especialidades_x_tecnico(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idTecnico);
			rs = stm.executeQuery();

			while (rs.next()) {
				esp = new DtoEspecialidad();
				esp.setIdEspecialidad(rs.getInt(1));
				esp.setNomEsp(rs.getString(2));
				esp.setSeleccionado(rs.getBoolean(3));
				lst.add(esp);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}

	public void actualizar(int idTecnico, int[] idsEspecialidad) {
		
		removerEspecialidades(idTecnico);
		String sql = "insert into tecnico_especialidad (id_tecnico, id_servicio) values (?,?)";
		cnx = getConnection();
		
		try {
			for (int id : idsEspecialidad) {
				stm = cnx.prepareStatement(sql);
				stm.setInt(1, idTecnico);
				stm.setInt(2, id);
				stm.executeUpdate();	
			}
		cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void removerEspecialidades(int idTecnico) {
		String sql = "delete from tecnico_especialidad where id_tecnico=?";
		cnx = getConnection();
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idTecnico);
			stm.executeUpdate();
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int maxId() {
		
		int idTecnico = -1;
		String sql = "select max(id_persona) from v_tecnicos";
		
		cnx = getConnection();
		ResultSet rs = null;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next()) {
				idTecnico = rs.getInt(1); 
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idTecnico;
	}
	
}
