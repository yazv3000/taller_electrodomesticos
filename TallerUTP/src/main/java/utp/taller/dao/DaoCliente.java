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
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.entidades.Cliente;

public class DaoCliente extends Conexion  implements BaseDAO<Cliente>{


	Connection cnx = null;
	PreparedStatement stm = null;

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
				tc.setIdTecnico(rs.getString(1));
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
	public List<Cliente> listar() {

		List<Cliente> lst = new ArrayList<Cliente>();
		Cliente c = null;

		String sql = "select * from cliente";	// inner join ....telefonos

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				c = new Cliente();
				//c.setIdCliente(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApePrin(rs.getString(3));
				c.setApeSec(rs.getString(4));
				// 5 - tipo de documento
				c.setNro_doc(rs.getString(6));
				c.setDireccion(rs.getString(7));
				c.setEmail(rs.getString(8));
				c.setContrasena(rs.getString(9));
				
				lst.add(c);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

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
