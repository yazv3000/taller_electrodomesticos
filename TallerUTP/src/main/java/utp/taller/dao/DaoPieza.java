package utp.taller.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.CategoriaPieza;
import utp.taller.entidades.Especialidad;
import utp.taller.entidades.Pieza;

public class DaoPieza extends Conexion implements CRUD<Pieza> {

	Connection cnx = null;
	PreparedStatement stm = null;

	public List<Pieza> listar() {

		List<Pieza> lst = new ArrayList<Pieza>();
		Pieza p = null;

		String sql = "select * from v_piezas";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				p = new Pieza();
				p.setIdPieza(rs.getInt("id_pieza"));
				p.setNomPieza(rs.getString("nombre_pieza"));
				p.setCategoria(new CategoriaPieza(rs.getInt("id_categoria"), rs.getString("nombre_cat")));
				p.setPrecio(rs.getDouble("precio_pieza"));
				p.setStock(rs.getLong("stock"));
				p.setEstadoActivo(rs.getBoolean("estado_activ"));
				
				lst.add(p);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;

	}

	public List<Pieza> listar(boolean estado) {

		List<Pieza> lst = new ArrayList<Pieza>();
		Pieza p = null;

		String sql = "select * from v_piezas where estado_activ = ?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setBoolean(1, estado);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				p = new Pieza();
				p.setIdPieza(rs.getInt("id_pieza"));
				p.setNomPieza(rs.getString("nombre_pieza"));
				p.setCategoria(new CategoriaPieza(rs.getInt("id_categoria"), rs.getString("nombre_cat")));
				p.setPrecio(rs.getDouble("precio_pieza"));
				p.setStock(rs.getLong("stock"));
				p.setEstadoActivo(rs.getBoolean("estado_activ"));
				
				lst.add(p);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;

	}

	@Override
	public Pieza consultarId(int id) {
		Pieza p = null;

		String sql = "select * from f_consultar_pieza(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();

			if (rs.next()) {
				p = new Pieza();
				p.setIdPieza(rs.getInt("id"));
				p.setNomPieza(rs.getString("nombre_pieza"));
				p.setCategoria(new CategoriaPieza(rs.getInt("id_categoria"), rs.getString("nom_categoria")));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getLong("stock"));
				p.setEstadoActivo(rs.getBoolean("estado"));
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return p;
	}
	
	@Override
	public int insertar(Pieza p) {		
		String sql = "call sp_nueva_pieza(?, ?, ?, ?)";
		cnx = getConnection();
		try {

			stm = cnx.prepareStatement(sql);
			stm.setString(1, p.getNomPieza());
			stm.setInt(2, p.getCategoria().getIdCategoria());
			stm.setDouble(3, p.getPrecio());
			stm.setLong(4, p.getStock());
			
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Pieza p) {
		String sql = "call sp_actualizar_pieza(?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, p.getIdPieza());
			stm.setString(2, p.getNomPieza());
			stm.setInt(3, p.getCategoria().getIdCategoria());
			stm.setBigDecimal(4, new BigDecimal(p.getPrecio()));
			stm.setLong(5, p.getStock());
			stm.setBoolean(6, p.isEstadoActivo());
			
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int cambiarEstado(int id, boolean estado) {
		
		String sql = "call sp_cambiar_estado_pieza(?, ?)";
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
	
	public List<CategoriaPieza> listarCategorias(){
		
		List<CategoriaPieza> lst = new ArrayList<CategoriaPieza>();
		CategoriaPieza cat = null;

		String sql = "select * from categoria_pieza";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				cat = new CategoriaPieza();
				cat.setIdCategoria(rs.getInt(1));
				cat.setNombreCat(rs.getString(2));

				lst.add(cat);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	
	}
	
}
