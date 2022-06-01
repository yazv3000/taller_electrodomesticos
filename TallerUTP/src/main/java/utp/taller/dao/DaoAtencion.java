package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import utp.config.Conexion;
import utp.taller.dto.DtoNuevaCita;
import utp.taller.entidades.Atencion;

public class DaoAtencion extends Conexion implements CRUD<Atencion> {
	

	Connection cnx = null;
	PreparedStatement stm = null;
	
	@Override
	public Atencion consultarId(int id) {
		
		return null;
	}

	@Override
	public int insertar(Atencion ate) {
		String sql = "INSERT INTO public.atencion(id_electro, id_horario, tipo, estado_atencion) VALUES (?, ?, ?, ?);";
		cnx = getConnection();
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, ate.getIdElectro());
			stm.setInt(2, ate.getIdHorario());
			stm.setString(3, ate.getLugar());
			stm.setString(4, ate.getEstAtencion());
			stm.execute();

			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Atencion ate) {
		
		return 0;
	}

	@Override
	public int cambiarEstado(int id, boolean estado) {
		
		return 0;
	}
	
	public void insertarCita(DtoNuevaCita cita) {
		String sql = "call sp_nueva_cita(?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, cita.getElectrodomestico().getIdElectrod());
			stm.setInt(2, cita.getDtoHora().getIdHorario());
			stm.setInt(3, cita.getServicio().getIdServicio());
			stm.setString(4, cita.getLugar());
			stm.setString(5, cita.getFallaElectrodomestico());
			stm.setObject(6, LocalDate.now());
			
			stm.execute(); 
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
