package utp.taller.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoHoraConsulta;
import utp.taller.entidades.Horario;

public class DaoHorario extends Conexion {

	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	Connection cnx = null;
	PreparedStatement stm = null;

	
	public List<Horario> listar() {

		List<Horario> lst = new ArrayList<Horario>();
		Horario h = null;

		String sql = "select * from v_horarios";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				h = new Horario();
				h.setIdHorario(rs.getInt("id_horario"));
				h.setIdTecnico(rs.getInt("id_tecnico"));

				try {
					h.setFechaAtencion(formato.parse(rs.getDate("fecha_atencion").toString()));	
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				h.setHoraInicio(rs.getString("hora_inicio").substring(0,5));
				h.setEstado(rs.getString("estado"));
				lst.add(h);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}
	
	public DtoHoraConsulta consultarDtoHora(int idHorario) {
		
		DtoHoraConsulta h = new DtoHoraConsulta();
		String sql = "select * from f_consultar_horario(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idHorario);
			rs = stm.executeQuery();

			if (rs.next()) {
				h = new DtoHoraConsulta();
				h.setIdHorario(rs.getInt("id_hora"));
				h.setNombreTecnico(rs.getString("tecnico"));
				h.setEspecialidad(rs.getString("especialidad"));
				h.setTelefonoTecnico(rs.getString("telefono"));
				h.setFotoTecnico(rs.getString("foto"));
				try {
					h.setFecha(formato.parse(rs.getDate("fecha").toString()));	
				} catch (ParseException e) {
					e.printStackTrace();
				}
				h.setHora(rs.getString("hora").substring(0,5));

			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return h;
	}
	
	//INSERTAR HORARIO 
	public void insertarHorario(Horario horario) {
		String sql = "call sp_nuevo_horario(?,?,?)";
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1,horario.getIdTecnico());
			long fecha = horario.getFechaAtencion().getTime();
			stm.setDate(2,Date.valueOf(formato.format(horario.getFechaAtencion())));
			stm.setTime(3, Time.valueOf(horario.getHoraInicio()));
			stm.execute();
			cnx.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void insertarHorarioTaller(Horario horario) {
		String sql = "insert into horario_atencion (id_tecnico, fecha_atencion, hora_inicio, estado) values (?,?,?,?)";
		cnx = getConnection();
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1,horario.getIdTecnico());
			stm.setObject(2, LocalDate.now());
			stm.setObject(3, LocalTime.now().truncatedTo(ChronoUnit.HOURS));
			stm.setString(4, "Reservado");
			stm.execute();
			cnx.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public int idHorario() {
		String sql = "select max(h.id_horario) as idHorario from horario_atencion as h";
		cnx = getConnection();
		ResultSet rs = null;
		int idHorario=0;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				idHorario = rs.getInt("idHorario");	
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idHorario;
	}
	public List<Horario> listarporIdTecnico(int idTec) {

		List<Horario> lst = new ArrayList<Horario>();
		Horario h = null;

		String sql = "select * from v_horarios where id_tecnico=?";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idTec);
			rs = stm.executeQuery();
			while (rs.next()) {
				h = new Horario();
				h.setIdHorario(rs.getInt("id_horario"));
				h.setIdTecnico(rs.getInt("id_tecnico"));

				try {
					h.setFechaAtencion(formato.parse(rs.getDate("fecha_atencion").toString()));	
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				h.setHoraInicio(rs.getString("hora_inicio").substring(0,5));
				h.setEstado(rs.getString("estado"));
				lst.add(h);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}
	
}
