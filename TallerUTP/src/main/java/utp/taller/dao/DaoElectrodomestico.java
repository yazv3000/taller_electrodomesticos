package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Electrodomestico;

public class DaoElectrodomestico extends Conexion implements BaseDAO<Electrodomestico> {

	/*
	 * TABLA electrodomestico
	 * 
	 * id_electrodomestico | nro_serie | id_tipoe | id_marca | modelo
	 */

	Connection cnx = null;
	PreparedStatement stm = null;


	public List<Electrodomestico> listar() {

		List<Electrodomestico> lst = new ArrayList<Electrodomestico>();
		Electrodomestico elec = null;

		String sql = "select E.*, TE.nom_tipo_electro, M.nom_marca from electrodomestico E inner join tipo_electro TE on TE.id_tipo_electro = E.id_tipoe inner join marca M on E.id_marca = M.id_marca";
		
		// (1) id_electrodomestico | (2) nro_serie | (3) id_tipoe |(4) id_marca | (5) modelo | (6) nom_tipo_electro | (7) nom_marca
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				elec = new Electrodomestico();
				elec.setIdElectrod(rs.getInt(1));
				elec.setNroSerie(rs.getString(2));
				elec.setModelo(rs.getString(5));
				elec.setTipoElectrod(rs.getString(6));
				elec.setMarca(rs.getString(7));
				
				lst.add(elec);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;

	}
	
	@Override
	public Electrodomestico consultarId(int id) {
		return null;
	}

	@Override
	public int insertar(Electrodomestico elec) {		
		String sql = "insert into electrodomestico(nro_serie, id_tipoe, id_marca, modelo) values (?, ?, ?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, elec.getNroSerie());
			stm.setInt(2, 1); 	// falta cambiar id_tipoe e id_marca a consulta
			stm.setInt(3, 1);
			stm.setString(4, elec.getModelo());
			
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Electrodomestico elec) {
		String sql = "update electrodomestico set nro_serie=?, id_tipoe=?, id_marca=?, modelo=? where id_electrodomestico=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, elec.getNroSerie());
			stm.setInt(2, 1); 	// falta cambiar id_tipoe e id_marca a consulta
			stm.setInt(3, 1);
			stm.setString(4, elec.getModelo());
			stm.setInt(5, elec.getIdElectrod());
			
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
		
		String sql = "delete from electrodomestico where id_electrodomestico=?";
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
	
	// CONSULTAR MARCAS
	public List<String> listarMarcas() {

		List<String> lst = new ArrayList<String>();

		String sql = "select * from marca";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				lst.add(rs.getString(2));
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}

	// CONSULTAR TIPOS DE ELECTRODOMÉSTICOS
	public List<String> listarTiposE() {

		List<String> lst = new ArrayList<String>();

		String sql = "select * from tipo_electro";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				lst.add(rs.getString(2));
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
}
