package utp.taller.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utp.config.Conexion;
import utp.taller.dto.DtoAtencion;
import utp.taller.dto.DtoCitaConsulta;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoNuevaCita;
import utp.taller.dto.DtoNuevoAtencionTaller;
import utp.taller.dto.DtoPresupuesto;
import utp.taller.dto.DtoReporteConsulta;
import utp.taller.dto.DtoServicioAtencion;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Servicio;

public class DaoAtencion extends Conexion {
	
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	Connection cnx = null;
	PreparedStatement stm = null;
	

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
	
	public void insertaratencionTaller(DtoNuevoAtencionTaller ate) {
		String sql = "call sp_nueva_cita(?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			DaoHorario daoH = new DaoHorario();
			stm = cnx.prepareCall(sql);
			stm.setInt(1, ate.getElectrodomestico().getIdElectrod());
			stm.setInt(2, daoH.idHorario());
			stm.setInt(3, ate.getServicio().getIdServicio());
			stm.setString(4, ate.getTipoAtencion());
			stm.setString(5, ate.getDiagnostico());
			stm.setObject(6, LocalDate.now());
			stm.execute(); 
			cnx.close();
		}	catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//LISTAR ATENCION
	public DtoAtencion obtenerAtencion(int idAtencion){
		System.out.println("Estoy ingresando al daodoo");
		DtoAtencion ate = null;
		String sql = "select * from f_resumen_atencion(?)";
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idAtencion);
			rs = stm.executeQuery();
			if (rs.next()) {
				System.out.println("Buscando registros");
				ate = new DtoAtencion();
				ate.setIdAtencion(idAtencion);
				DtoClienteConsulta cliente = new DtoClienteConsulta();
				cliente.setEmail(rs.getString("email"));
				cliente.setNombreCompleto(rs.getString("nombre_cliente"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setDistrito(rs.getString("distrito"));
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
				ate.setTipoAtencion(rs.getString("lugar"));
				ate.setFallaDescrita(rs.getString("falla_descrita"));
				
				ate.setFechaReservaCita(rs.getDate("fecha_reserva_cita"));
				ate.setEstado(rs.getString("estado_atencion"));
			}
			else {
				System.out.println("No lo encuentra");
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
				cita = recuperarDatosCita(rs);
				cita.setServicios(recuperarServiciosAtencion(cita.getIdAtencion()));
				lst.add(cita);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public double obtenerMontoTotal(int idAtencion) {
		double montoTotal = 0;
		String sql = "select atencion.monto_total from atencion where id_atencion=? ";
		cnx = getConnection();
		ResultSet rs = null;
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idAtencion);
			rs = stm.executeQuery();
			if (rs.next()) {
				montoTotal = rs.getDouble("monto_total");
			}
			cnx.close();
		}	catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return montoTotal;
	}
	
	public List<DtoCitaConsulta> listarCitasCliente(int idCliente){
		List<DtoCitaConsulta> lst = new ArrayList<DtoCitaConsulta>();
		String sql = "select * from v_citas_domicilio where id_cliente=? ";
		DtoCitaConsulta cita = null;
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idCliente);
			rs = stm.executeQuery();

			while (rs.next()) {
				cita = recuperarDatosCita(rs);
				cita.setServicios(recuperarServiciosAtencion(cita.getIdAtencion()));
				lst.add(cita);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	public List<DtoCitaConsulta> listarAtencionesCliente(int idCliente){
		List<DtoCitaConsulta> lst = new ArrayList<DtoCitaConsulta>();
		String sql = "select * from v_citas_domicilio where id_cliente=? ";
		DtoCitaConsulta cita = null;
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idCliente);
			rs = stm.executeQuery();

			while (rs.next()) {
				cita = recuperarDatosCita(rs);
				cita.setServicios(recuperarServiciosAtencion(cita.getIdAtencion()));
				lst.add(cita);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	
	public DtoCitaConsulta recuperarDatosCita(ResultSet rs) {
		DtoCitaConsulta cita = new DtoCitaConsulta();
		try {
			cita.setIdAtencion(rs.getInt("id_atencion"));
			cita.setNombreCliente(rs.getString("nombre_cliente"));
			cita.setNombreTecnico(rs.getString("nombre_tecnico"));
			cita.setDistritoYdireccion(rs.getString("direc_cliente"));
			cita.setTipoElectrodomestico(rs.getString("tipo_electro"));
			cita.setHoraAtencion(rs.getString("hora_inicio"));
			cita.setFechaAtencion(rs.getDate("fecha_atencion"));
			cita.setLugar(rs.getString("lugar"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cita;
	}
	
	public Set<DtoServicioAtencion> recuperarServiciosAtencion(int idAtencion) {
		Set<DtoServicioAtencion> set = new HashSet<DtoServicioAtencion>();
		String sql = "select S.id_servicio, S.nombre_serv, D.estado_completo from detalle_atencion D inner join servicio S on D.id_servicio = S.id_servicio where id_atencion =? ";
		DtoServicioAtencion serv = null;
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idAtencion);
			rs = stm.executeQuery();

			while (rs.next()) {
				serv = new DtoServicioAtencion();
				serv.setIdServicio(rs.getInt("id_servicio"));
				serv.setNomServicio(rs.getString("nombre_serv"));
				serv.setEstadoCompleto(rs.getBoolean("estado_completo"));
				System.out.println(rs.getString("nombre_serv"));
				set.add(serv);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return set;
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
	
	//OBTENER EL ID MAXIMO DEL CLIENTE
	public int idMaxCliente () {
		String sql = "select max(u.id_persona) as idMaximo from usuario as u where u.id_rol = 1";
		cnx = getConnection();
		ResultSet rs = null;
		int idMaximo = 0;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				idMaximo = rs.getInt("idMaximo");
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idMaximo;
	}
	//OBETENER EL ID MAXIMO DE LA ATENCION
	public int idMaxAtencion () {
		String sql = "select max(a.id_atencion) as idMaximo from atencion as a";
		cnx = getConnection();
		ResultSet rs = null;
		int idMaximo = 0;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				idMaximo = rs.getInt("idMaximo");
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idMaximo;
	}
	public int getidElectrodomestico () {
		String sql = "select e.id_electrodomestico as idElec from electrodomestico as e where e.id_propietario= \r\n"
				+ "(select max(u.id_persona) from usuario as u where u.id_rol = 1);";
		cnx = getConnection();
		ResultSet rs = null;
		int idElec = 0;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				idElec = rs.getInt("idElec");
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idElec;
	}

	public void finalizarAtencionDomicilio(int idAtencion, int idServ, double presupuestoServ) {
		
		String sql = "call sp_fin_atencion_domicilio(?, ?, ?, ?, ?, ?)";
		
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, idAtencion);
			stm.setInt(2, idServ);
			// TODO
			stm.setBoolean(3, true);	// presupuesto aceptado
			stm.setBigDecimal(4, new BigDecimal(10));	// visita
			stm.setBigDecimal(5, new BigDecimal(25));	// diagnostico
			stm.setBigDecimal(6, new BigDecimal(presupuestoServ));
			stm.execute(); 
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void presupuestoEnEspera(int idAtencion, int idServ, double presupuestoServ) {
		
		String sql = "call sp_presupuesto_espera(?, ?, ?, ?, ?, ?)";
		
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, idAtencion);
			stm.setInt(2, idServ);
			// TODO
			stm.setBoolean(3, true);	// presupuesto aceptado
			stm.setBigDecimal(4, new BigDecimal(10));	// visita
			stm.setBigDecimal(5, new BigDecimal(25));	// diagnostico
			stm.setBigDecimal(6, new BigDecimal(presupuestoServ));
			stm.execute(); 
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void confirmar(int codAtencion) {
		String sql = "UPDATE public.atencion SET  estado_atencion='Finalizado' WHERE atencion.id_atencion=?;";
		cnx = getConnection();
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, codAtencion);
			stm.execute();
			cnx.close();
		}	catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void cancelarPresupuesto(int codAtencion) {
		String sql = "UPDATE public.atencion SET  estado_atencion='Cancelado' WHERE atencion.id_atencion=?;";
		cnx = getConnection();
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, codAtencion);
			stm.execute();
			cnx.close();
		}	catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// REPORTES
		public List<DtoReporteConsulta> listarReportes(){
			List<DtoReporteConsulta> lst = new ArrayList<DtoReporteConsulta>();
			String sql = "select * from v_atenciones_finalizadas";
			DtoReporteConsulta aten = null;
			cnx = getConnection();
			ResultSet rs = null;

			try {
				stm = cnx.prepareStatement(sql);
				rs = stm.executeQuery();

				while (rs.next()) {
					aten = recuperarReporte(rs);
					lst.add(aten);
				}	
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
		
		
		public List<DtoReporteConsulta> listarReportesTecnico(int idTecnico, Date fecha1, Date fecha2){
			List<DtoReporteConsulta> lst = new ArrayList<DtoReporteConsulta>();
			String sql = "select * from f_reportes_x_tecnico(?,?,?) ";
			DtoReporteConsulta aten = null;
			cnx = getConnection();
			ResultSet rs = null;

			try {
				stm = cnx.prepareStatement(sql);
				stm.setInt(1, idTecnico);
				stm.setObject(2, fecha1, Types.DATE);
				stm.setObject(3, fecha2, Types.DATE);
				System.out.println(stm+"-------------------------------STM WE");
				
				rs = stm.executeQuery();

				while (rs.next()) {
					aten = recuperarReporte(rs);
					lst.add(aten);
				}	
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
		
		public List<DtoReporteConsulta> listarReportesCliente(int idCliente, Date fecha1, Date fecha2, double monto1, double monto2){
			List<DtoReporteConsulta> lst = new ArrayList<DtoReporteConsulta>();
			String sql = "select * from f_reportes_x_cliente(?,?,?,?,?) ";
			DtoReporteConsulta aten = null;
			cnx = getConnection();
			ResultSet rs = null;

			try {
				stm = cnx.prepareStatement(sql);
				stm.setInt(1, idCliente);
				stm.setObject(2, fecha1, Types.DATE);
				stm.setObject(3, fecha2, Types.DATE);
				stm.setBigDecimal(4, new BigDecimal(monto1));
				stm.setBigDecimal(5, new BigDecimal(monto2));
				rs = stm.executeQuery();

				while (rs.next()) {
					aten = recuperarReporte(rs);
					lst.add(aten);
				}	
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
		
		
		public DtoReporteConsulta recuperarReporte(ResultSet rs) {
			DtoReporteConsulta aten = new DtoReporteConsulta();
			try {
				aten = new DtoReporteConsulta();
				aten.setIdAtencion(rs.getInt("id_atencion"));
				aten.setFecha(rs.getDate("fecha_atencion"));
				aten.setHora(rs.getString("hora").substring(0, 5));
				aten.setNombreTecnico(rs.getString("tecnico"));
				aten.setNombreCliente(rs.getString("cliente"));
				aten.setElectrodomestico(rs.getString("electrodomestico"));
				aten.setMarca(rs.getString("marca"));
				aten.setServicio(rs.getString("servicios"));
				aten.setMonto(rs.getDouble("monto_total"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return aten;
		}
		//OBTENER LISTA DE PRESUPUESTO
		public List<DtoPresupuesto> listarPresupuesto(int idAtencion){
			List<DtoPresupuesto> lst = new ArrayList<DtoPresupuesto>();
			String sql = "select * from f_cuerpo_reporte(?) ";
			DtoPresupuesto presupuesto = null;
			cnx = getConnection();
			ResultSet rs = null;

			try {
				stm = cnx.prepareStatement(sql);
				stm.setInt(1, idAtencion);
				rs = stm.executeQuery();
				while (rs.next()) {
					presupuesto = new DtoPresupuesto();
					presupuesto.setServicio(rs.getString(3));
					presupuesto.setNombre(rs.getString(2));
					presupuesto.setPrecio(rs.getString(4));
					lst.add(presupuesto);
				}	
				cnx.close();
			}	catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}

//		public void bloquearHorarioDiaActual() {
//			String sql = "call sp_desactivar_horarios_pasados()";
//			cnx = getConnection();
//			try {
//				stm = cnx.prepareCall(sql);
//				stm.execute();
//				cnx.close();
//			}	catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
}
