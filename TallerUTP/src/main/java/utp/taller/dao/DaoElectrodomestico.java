package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.dto.DtoElectrodomesticoConsulta;

public class DaoElectrodomestico extends Conexion implements CRUD<Electrodomestico> {

	Connection cnx = null;
	PreparedStatement stm = null;

	// OPERACIONES CRUD
	@Override
	public Electrodomestico consultarId(int id) {
		
		Electrodomestico elec = null;
		cnx = getConnection();
		ResultSet rs = null;
		

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
	public int cambiarEstado(int id, boolean estado) {
		
		String sql = "call sp_cambiar_estado_electrodomestico(?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			stm.setBoolean(2, estado);
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	public List<DtoElectrodomesticoConsulta> listarDtoElectrodomesticos() {

		List<DtoElectrodomesticoConsulta> lst = new ArrayList<DtoElectrodomesticoConsulta>();
		DtoElectrodomesticoConsulta elec = new DtoElectrodomesticoConsulta();

		String sql = "select * from v_electrodomesticos";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				elec = recuperarDatosDto(rs);
				lst.add(elec);
			}
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}
	
	public List<DtoElectrodomesticoConsulta> listarDtoElectrodomesticos(boolean estado) {

		List<DtoElectrodomesticoConsulta> lst = new ArrayList<DtoElectrodomesticoConsulta>();
		DtoElectrodomesticoConsulta elec = new DtoElectrodomesticoConsulta();

		String sql = "select * from v_electrodomesticos";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				elec = recuperarDatosDto(rs);
				lst.add(elec);
			}
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}
	
	// MÉTODOS PRIVADOS
	private DtoElectrodomesticoConsulta recuperarDatosDto(ResultSet rs ) {
		
		DtoElectrodomesticoConsulta electro = new DtoElectrodomesticoConsulta();
		try {
			electro.setIdElectrodomestico(rs.getInt("id_electrodomestico"));
			electro.setNroSerie(rs.getString("nro_serie"));
			electro.setTipo(rs.getString("tipo"));
			electro.setModelo(rs.getString("modelo"));
			electro.setMarca(rs.getString("marca"));
			electro.setNombrePropietario(rs.getString("propietario"));
			electro.setMarca(rs.getString("marca"));
			electro.setEstadoActivo(rs.getBoolean("estado_activ"));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return electro;
	}




	
	
	// CONSULTAR MARCAS
		public List<ElectrodomesticoMarca> listarMarcas() {

			List<ElectrodomesticoMarca> lst = new ArrayList<>();
			ElectrodomesticoMarca marca = null;
			
			String sql = "select * from marca";

			cnx = getConnection();
			ResultSet rs = null;

			try {
				stm = cnx.prepareStatement(sql);
				rs = stm.executeQuery();

				while (rs.next()) {
					marca = new ElectrodomesticoMarca();
					
					marca.setId(rs.getInt(1));
					marca.setNombre(rs.getString(2));
					marca.setEstado(rs.getBoolean(3));
					
					lst.add(marca);
				}
				
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}

		// CONSULTAR TIPOS DE ELECTRODOMÉSTICOS
		public List<ElectrodomesticoTipo> listarTiposE() {

			List<ElectrodomesticoTipo> lst = new ArrayList<ElectrodomesticoTipo>();
			ElectrodomesticoTipo tipo = null;
			String sql = "select * from tipo_electrodomestico";

			cnx = getConnection();
			ResultSet rs = null;

			try {
				stm = cnx.prepareStatement(sql);
				rs = stm.executeQuery();

				while (rs.next()) {
					tipo = new ElectrodomesticoTipo();
					tipo.setId(rs.getInt(1));
					tipo.setNombre(rs.getString(2));
					tipo.setEstado(rs.getBoolean(3));
					lst.add(tipo);
				}
				cnx.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
	
}
