package utp.taller.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoAtencion;
import utp.taller.dto.DtoCitaConsulta;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoNuevaCita;
import utp.taller.entidades.Atencion;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Servicio;

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
	public DtoAtencion obtenerAtencion(int idAtencion){
		DtoAtencion ate = null;
		String sql = "select * from v_resumen_atencion where id_atencion=?";
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idAtencion);
			rs = stm.executeQuery();
			if (rs.next()) {
				ate = new DtoAtencion();
				ate.setIdCita(rs.getInt(1)+"");
				DtoClienteConsulta cliente = new DtoClienteConsulta();
				cliente.setNombreCompleto(rs.getString("nombres"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setDistrito(rs.getString("nombre_distrito"));
				cliente.setDireccion(rs.getString("direccion"));
				ate.setCliente(cliente);
				
				ate.setFechaCita(rs.getDate("fecha_atencion"));
				
				Servicio servicio = new Servicio();
				servicio.setIdServicio(rs.getInt("id_servicio"));
				servicio.setNomServicio(rs.getString("nombre_serv"));
				ate.setServicio(servicio);
				
				
				
				Electrodomestico electro = new Electrodomestico();
				electro.setNroSerie(rs.getString("nro_serie"));
				electro.setModelo(rs.getString("modelo"));
				ate.setElectrodomestico(electro);
				
				ElectrodomesticoTipo elecTipo = new ElectrodomesticoTipo();
				elecTipo.setNombre(rs.getString("tipo_electro"));
				ate.setElectrodomesticoTipo(elecTipo);
				
				ElectrodomesticoMarca elecMarca = new ElectrodomesticoMarca();
				elecMarca.setNombre(rs.getString("marca"));
				ate.setElectrodomesticoMarca(elecMarca);
				
				ate.setHoraCita(rs.getString("hora_inicio"));
				ate.setTipoAtencion(rs.getString("tipo"));
				ate.setFallaDescrita(rs.getString("falla_descrita"));
				
				ate.setFechaReservaCita(rs.getDate("fecha_reserva_cita"));
				ate.setEstado(rs.getString("estado_atencion"));
			}
			cnx.close();
		}	catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ate;
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
				cita.setFechaAtencion(rs.getDate("fecha_atencion"));	

				lst.add(cita);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}

	// AGREGAR UNA VENTA
	public void agregarVenta(int idAtencion, double monto) {
		String sql = "call sp_agregar_venta(?, ?)";
		
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, idAtencion);
			stm.setBigDecimal(2, new BigDecimal(monto));
			stm.execute(); 
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
