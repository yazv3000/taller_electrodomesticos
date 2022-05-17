package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utp.config.Conexion;
import utp.taller.dto.DtoClienteConsulta;
import utp.taller.dto.DtoUsuario;
import utp.taller.entidades.Cliente;

public class DaoCliente extends Conexion  implements BaseDAO<Cliente>{


	Connection cnx = null;
	PreparedStatement stm = null;

	public DtoUsuario validar(String email, String contra) {
		DtoUsuario dtoClie = new DtoUsuario();
		String sql = "select * from usuario where email=? and contra=?";
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, contra);
			rs = stm.executeQuery();
			while (rs.next()) {
				dtoClie.setCorreo(rs.getString("email"));
				dtoClie.setContra(rs.getString("contra"));
			}
			cnx.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return dtoClie;
	}
	
	
	
	public List<DtoClienteConsulta> listarDtoClientes() {
		List<DtoClienteConsulta> lst = new ArrayList<DtoClienteConsulta>();
		DtoClienteConsulta tc = null;
		String sql = "select * from f_listar_clientes()";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				tc = new DtoClienteConsulta();
				tc.setIdCliente(rs.getString(1));
				tc.setNombreCompleto(rs.getString(2));
				tc.setTelefono(rs.getString(3));
				tc.setDireccion(rs.getString(4));
				tc.setEmail(rs.getString(5));
				lst.add(tc);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	@Override
	public Cliente consultarId(String idCliente) {

		Cliente c = null;

		String sql = "select P.*, U.email, U.contra from persona P inner join usuario U on P.id_persona = U.id_persona where P.id_rol=3 and P.id_persona=?";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, idCliente);
			rs = stm.executeQuery();

			if (rs.next()) {
				c = new Cliente();
				c.setIdCliente(rs.getString(1));
				c.setNombre(rs.getString(3));
				c.setApePrin(rs.getString(4));
				c.setApeSec(rs.getString(5));
				c.setTipo_doc(rs.getInt(6));
				c.setNro_doc(rs.getString(7));
				c.setTelefono(rs.getString(8));
				c.setDireccion(rs.getString(9));
				c.setEmail(rs.getString(11));
				c.setContrasena(rs.getString(12));
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return c;

	}
	


	@Override
	public int insertar(Cliente c) {
		String sql = "insert into cliente(nom_cli, ape1_cli, ape2_cli, id_tdoc, nro_doc, direccion, email_cli, contra_cli) values (?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, c.getNombre());
			stm.setString(2, c.getApePrin());
			stm.setString(3, c.getApeSec());
			stm.setInt(4, 1);		// 1 = dni
			stm.setString(5, c.getNro_doc());
			stm.setString(6, c.getDireccion());
			stm.setString(7, c.getEmail());
			stm.setString(8, c.getContrasena());
			
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Cliente c) {
		String sql = "update cliente set nom_cli=?, ape1_cli=?, ape2_cli=?, id_tdoc=?, nro_doc=?, direccion=?, email_cli=?, contra_cli=? where id_cliente=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, c.getNombre());
			stm.setString(2, c.getApePrin());
			stm.setString(3, c.getApeSec());
			stm.setInt(4, 1);		// 1 = dni
			stm.setString(5, c.getNro_doc());
			stm.setString(6, c.getDireccion());
			stm.setString(7, c.getEmail());
			stm.setString(8, c.getContrasena());
			//stm.setInt(9, c.getIdCliente());
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int eliminar(int id) {
		
		String sql = "delete from cliente where id_cliente=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	// CONSULTAR TELÉFONOS POR id_cliente
	public Set<String> telefonos_cliente(int idCliente) {
		Set<String> tel = new HashSet<String>();
		
		String sql = "select * from cliente_contacto where id_cliente=?";
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idCliente);
			rs = stm.executeQuery();

			while (rs.next()) {
				tel.add(rs.getString(2));
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return tel;
	}


}
