package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
}
