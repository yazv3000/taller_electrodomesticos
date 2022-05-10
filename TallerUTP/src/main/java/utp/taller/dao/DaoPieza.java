package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Pieza;

public class DaoPieza extends Conexion implements BaseDAO<Pieza> {

	/*
	 * TABLA pieza
	 * 
	 * id_pieza | nomPieza | stock | precio_pieza | id_cat
	 */

	Connection cnx = null;
	PreparedStatement stm = null;

	@Override
	public List<Pieza> listar() {

		List<Pieza> lst = new ArrayList<Pieza>();
		Pieza p = null;

		String sql = "select P.*, C.nom_cat from pieza P inner join categoria_pieza C on P.id_cat = C.id_categoria";
		
		// (1) id_pieza | (2) nomPieza | (3) stock | (4) precio_pieza | (5) id_cat | (6) nom_cat
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				p = new Pieza();
				p.setIdPieza(rs.getInt(1));
				p.setNomPieza(rs.getString(2));
				p.setStock(rs.getLong(3));
				p.setPrecio(rs.getDouble(4));
				p.setCategoria(rs.getString(6));
				
				lst.add(p);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;

	}

	@Override
	public int insertar(Pieza p) {		
		String sql = "insert into pieza(nom_pieza, stock, precio_pieza, id_cat) values (?, ?, ?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, p.getNomPieza());
			stm.setLong(2, p.getStock());
			stm.setDouble(3, p.getPrecio());
			stm.setInt(4, 1);	// falta cambiar id_cat a consulta
			
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Pieza p) {
		String sql = "update pieza set nom_pieza=?, stock=?, precio_pieza=?, id_cat=? where id_pieza=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, p.getNomPieza());
			stm.setLong(2, p.getStock());
			stm.setDouble(3, p.getPrecio());
			stm.setInt(4, 1);	// falta cambiar id_cat a consulta
			stm.setInt(5, p.getIdPieza());
			
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
		
		String sql = "delete from pieza where id_pieza=?";
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
	
	// CONSULTAR CATEGOR�A DE PIEZAS
	
	
}
