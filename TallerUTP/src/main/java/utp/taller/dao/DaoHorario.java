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
import utp.taller.dto.DtoConsultaCita;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoHorario;

public class DaoHorario extends Conexion {

	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	Connection cnx = null;
	PreparedStatement stm = null;

	
	
	public List<DtoHorario> listar() {

		
		List<DtoHorario> lst = new ArrayList<DtoHorario>();
		DtoHorario h = null;

		String sql = "select * from v_horarios";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				h = new DtoHorario();
				h.setIdHorario(rs.getInt(1));
				h.setIdTecnico(rs.getInt(2));

				try {
					h.setFechaAtencion(formato.parse(rs.getDate(3).toString()));		// corregir esto
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				h.setHoraInicio(rs.getString(4).substring(0,5));
				
				h.setEstado(rs.getString(5));
				lst.add(h);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;

	}
	
	public DtoConsultaCita seleccionarHora(int idHora, String idServicio) {
		DtoConsultaCita dtoCita = new DtoConsultaCita();
		String sql = "select * from f_consultar_cita(?,?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idHora);
			stm.setString(2, idServicio);
			rs = stm.executeQuery();

			if (rs.next()) {
				dtoCita.setIdHorario(rs.getInt(1));
				dtoCita.setNombres(rs.getString(2));
				dtoCita.setEspecialidad(rs.getString(3));
				dtoCita.setTelefono(rs.getString(4));
				dtoCita.setServicio(rs.getString(5));
				try {
					dtoCita.setFecha(formato.parse(rs.getDate(6).toString()));		
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				dtoCita.setHora(rs.getString(7).substring(0,5));
				dtoCita.setEstado(rs.getString(8));
				dtoCita.setLugar(rs.getString(9));
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return dtoCita;
	}

	
}
