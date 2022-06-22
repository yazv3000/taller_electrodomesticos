package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Cliente;

public class DaoCliente extends Conexion implements CRUD<Cliente>{

	Connection cnx = null;
	PreparedStatement stm = null;
	
	// AUTENTICACIÓN CLIENTE
	public DtoUsuario validar(String email, String contra) {
		DtoUsuario dtoClie = new DtoUsuario();
		String sql = "select * from f_validar_acceso(1,?,?)";
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, contra);
			rs = stm.executeQuery();
			if (rs.next()) {
				dtoClie.setIdPersona(rs.getInt(1));
				dtoClie.setIdUsuario(rs.getString(2));
				dtoClie.setRol(rs.getString(3));
				dtoClie.setUsername(rs.getString(4));
				dtoClie.setEmail(rs.getString(5));
				dtoClie.setProfilePic(rs.getString(6));
			}
			cnx.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return dtoClie;
	}
	
	// OPERACIONES CRUD
	@Override
	public Cliente consultarId(int idCliente) {

		Cliente cli = null;

		String sql = "select * from f_consultar_cliente(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idCliente);
			rs = stm.executeQuery();

			if (rs.next()) {
				cli = new Cliente();
				cli.setIdPersonaCliente(rs.getInt(1));
				cli.setIdUsuarioCliente(rs.getString(2));
				cli.setNombrePrin(rs.getString(3));
				cli.setNombreSec(rs.getString(4));
				cli.setApePrin(rs.getString(5));
				cli.setApeSec(rs.getString(6));
				cli.setTipoDocumento(rs.getInt(7));
				cli.setNroDocumento(rs.getString(8));
				cli.setTelefono(rs.getString(9));
				cli.setIdDistrito(rs.getInt(10));
				cli.setDireccion(rs.getString(11));
				cli.setEmail(rs.getString(12));
				cli.setContrasena(rs.getString(13));
				cli.setRutaFoto(rs.getString(14));
				cli.setEstadoActivo(rs.getBoolean(15));
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cli;

	}
	
	@Override
	public int insertar(Cliente cli) {
		String sql = "call sp_nuevo_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		
		try {
			stm = cnx.prepareCall(sql);
			stm.setString(1, cli.getNombrePrin());
			stm.setString(2, cli.getNombreSec());
			stm.setString(3, cli.getApePrin());
			stm.setString(4, cli.getApeSec());
			stm.setInt(5, cli.getTipoDocumento());
			stm.setString(6, cli.getNroDocumento());
			stm.setString(7, cli.getTelefono());
			stm.setInt(8, cli.getIdDistrito());
			stm.setString(9, cli.getDireccion());
			stm.setString(10, cli.getEmail());
			stm.setString(11, cli.getContrasena());
			stm.setString(12, cli.getRutaFoto());
			stm.execute(); 
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	@Override
	public int modificar(Cliente c) {
		String sql = "call sp_actualizar_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareCall(sql);
			stm.setInt(1, c.getIdPersonaCliente());
			stm.setString(2, c.getIdUsuarioCliente());
			stm.setString(3, c.getNombrePrin());
			stm.setString(4, c.getNombreSec());
			stm.setString(5, c.getApePrin());
			stm.setString(6, c.getApeSec());
			stm.setInt(7, c.getTipoDocumento());
			stm.setString(8, c.getNroDocumento());
			stm.setString(9, c.getTelefono());
			stm.setInt(10, c.getIdDistrito());
			stm.setString(11, c.getDireccion());
			stm.setString(12, c.getEmail());
			stm.setString(13, c.getContrasena());
			stm.setBoolean(14, c.isEstadoActivo());
			stm.setString(15, c.getRutaFoto());
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
	
	public DtoClienteConsulta consultarDtoNombres(String nombreCliente) {
		DtoClienteConsulta cli = new DtoClienteConsulta();

		String sql = "select * from v_clientes where upper(nombres) like ?";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, "%"+nombreCliente.toUpperCase()+"%");
			rs = stm.executeQuery();
			if (rs.next()) {
				cli = recuperarDatosDto(rs);
			}
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cli;
	}
	
	// LISTA DE CLIENTES PARA MOSTRAR EN LA TABLA DE MANTENIMIENTO
	public List<DtoClienteConsulta> listarDtoClientes() {
		
		List<DtoClienteConsulta> lst = new ArrayList<DtoClienteConsulta>();
		DtoClienteConsulta cli = null;
		String sql = "select * from v_clientes";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				cli = recuperarDatosDto(rs);
				lst.add(cli);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public List<DtoClienteConsulta> listarDtoClientes(boolean estado) {
		
		List<DtoClienteConsulta> lst = new ArrayList<DtoClienteConsulta>();
		DtoClienteConsulta cli = null;
		String sql = "select * from v_clientes where estado_activ = ?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setBoolean(1, estado);
			rs = stm.executeQuery();

			while (rs.next()) {
				cli = recuperarDatosDto(rs);
				lst.add(cli);
			}	
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	// MÉTODOS PRIVADOS
	private DtoClienteConsulta recuperarDatosDto(ResultSet rs ) {
		DtoClienteConsulta cli = new DtoClienteConsulta();
		try {
				cli.setIdPersonaCliente(rs.getInt("id_persona"));
				cli.setIdUsuarioCliente(rs.getString("id_user"));
				cli.setNombreCompleto(rs.getString("nombres"));
				cli.setTelefono(rs.getString("telefono"));
				cli.setDistrito(rs.getString("nombre_distrito"));			
				cli.setDireccion(rs.getString("direccion"));
				cli.setEmail(rs.getString("email"));
				cli.setEstadoActivo(rs.getBoolean("estado_activ"));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}
	
}
