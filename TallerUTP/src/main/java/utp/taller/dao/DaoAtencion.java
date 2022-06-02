package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import utp.config.Conexion;
import utp.taller.dto.DtoNuevaCita;
import utp.taller.dto.DtoAtencion;
import utp.taller.dto.DtoCitaConsulta;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.entidades.Atencion;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Servicio;

import java.util.ArrayList;
import java.util.List;

public class DaoAtencion extends Conexion implements CRUD<Atencion> {
	
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	Connection cnx = null;
	PreparedStatement stm = null;
	
	@Override
	public Atencion consultarId(int id) {
		
		return null;
	}

	@Override
	public int insertar(Atencion ate) {
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
	//LISTAR ATENCION
	public List<DtoAtencion> listarAtencion(){
		List<DtoAtencion> lst = new ArrayList<DtoAtencion>();
		DtoAtencion ate = null;
		String sql = "select * from v_resumenAtencion";
		cnx = getConnection();
		ResultSet rs = null;
		try {
			while (rs.next()) {
				ate.setIdCita(rs.getInt(1)+"");
				DtoClienteConsulta cliente = new DtoClienteConsulta();
				cliente.setNombreCompleto(rs.getString(2));
				cliente.setTelefono(rs.getString(3));
				cliente.setDistrito(rs.getString(4));
				cliente.setDireccion(rs.getString(5));
				ate.setCliente(cliente);
				Servicio servicio = new Servicio();
				servicio.setNomServicio(rs.getString(6));
				ate.setServicio(servicio);
				Electrodomestico electro = new Electrodomestico();
				electro.setNroSerie(rs.getString(7));
				ElectrodomesticoTipo elecTipo = new ElectrodomesticoTipo();
				elecTipo.setNombre(rs.getString(8));
				electro.setModelo(rs.getString(9));
				ElectrodomesticoMarca elecMarca = new ElectrodomesticoMarca();
				elecMarca.setNombre(rs.getString(10));
			}
		}	catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

	}
	
	// LISTAR CITAS
	public List<DtoCitaConsulta> listarCitasDomicilio(int idTecnico){
		List<DtoCitaConsulta> lst = new ArrayList<DtoCitaConsulta>();
		String sql = "select * from v_citas_domicilio where id_tecnico=? ";
		DtoCitaConsulta cita = null;
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idTecnico);
			rs = stm.executeQuery();

			while (rs.next()) {
				cita = new DtoCitaConsulta();
				cita.setIdAtencion(rs.getInt("id_atencion"));
				cita.setNombreCliente(rs.getString("nombre_cliente"));
				cita.setDistritoYdireccion(rs.getString("direc_cliente"));
				cita.setTipoElectrodomestico(rs.getString("tipo_electro"));
				cita.setHoraAtencion(rs.getString("hora_inicio"));
				try {
					cita.setFechaAtencion(formato.parse(rs.getDate("fecha_atencion").toString()));	
				} catch (ParseException e) {
					e.printStackTrace();
				}
				lst.add(cita);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
}
