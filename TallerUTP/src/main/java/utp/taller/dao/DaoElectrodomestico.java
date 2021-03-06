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
		
		String sql = "select * from electrodomestico where id_electrodomestico = ?";
		
		cnx = getConnection();
		ResultSet rs = null;
		
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			if (rs.next()){
				elec = new Electrodomestico();
				elec.setIdElectrod(rs.getInt("id_electrodomestico"));
				elec.setNroSerie(rs.getString("nro_serie"));
				elec.setIdtipoElectrod(rs.getInt("id_tipo_electro"));
				elec.setModelo(rs.getString("modelo"));
				elec.setIdmarca(rs.getInt("id_marca"));
				elec.setIdpropietario(rs.getInt("id_propietario"));
				elec.setEstadoActivo(rs.getBoolean("estado_activ"));
			}	
			
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return elec;
	}

	@Override
	public int insertar(Electrodomestico elec) {		
		String sql = "call sp_nuevo_electrodomestico(?,?,?,?,?)";
		cnx = getConnection();
		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, elec.getNroSerie());
			stm.setInt(2, elec.getIdtipoElectrod()); 
			stm.setString(3, elec.getModelo());
			stm.setInt(4, elec.getIdmarca());
			stm.setInt(5, elec.getIdpropietario());
			
			stm.execute();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Electrodomestico elec) {
		String sql = "update electrodomestico set nro_serie=?, id_tipo_electro=?, id_marca=?, modelo=?, id_propietario=? where id_electrodomestico=?";
		cnx = getConnection();
		try {
			
			stm = cnx.prepareStatement(sql);
			stm.setString(1, elec.getNroSerie());
			stm.setInt(2, elec.getIdtipoElectrod()); 	// falta cambiar id_tipoe e id_marca a consulta
			stm.setInt(3, elec.getIdmarca());
			stm.setString(4, elec.getModelo());
			stm.setInt(5, elec.getIdpropietario());
			
			stm.setInt(6, elec.getIdElectrod());
			
			stm.executeUpdate();
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
	
	public DtoElectrodomesticoConsulta  consultarElectrodomesticoId(int id) {
		
		DtoElectrodomesticoConsulta elec = new DtoElectrodomesticoConsulta();

		String sql = "select * from v_electrodomesticos where id_electrodomestico = ?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();

			if (rs.next()) {
				elec = recuperarDatosDto(rs);
			}
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return elec;
	}
	
	
	public List<DtoElectrodomesticoConsulta> listarDtoElectrodomesticos(boolean estado) {

		List<DtoElectrodomesticoConsulta> lst = new ArrayList<DtoElectrodomesticoConsulta>();
		DtoElectrodomesticoConsulta elec = new DtoElectrodomesticoConsulta();

		String sql = "select * from v_electrodomesticos where estado_activ = ?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setBoolean(1, estado);
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
	
	// M?TODOS PRIVADOS
	private DtoElectrodomesticoConsulta recuperarDatosDto(ResultSet rs ) {
		
		DtoElectrodomesticoConsulta electro = new DtoElectrodomesticoConsulta();
		try {
			electro.setIdElectrodomestico(rs.getInt("id_electrodomestico"));
			electro.setNroSerie(rs.getString("nro_serie"));
			electro.setTipo(rs.getString("tipo"));
			electro.setModelo(rs.getString("modelo"));
			electro.setMarca(rs.getString("marca"));
			electro.setNombrePropietario(rs.getString("propietario"));
			electro.setEstadoActivo(rs.getBoolean("estado_activ"));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return electro;
	}

	// CONSULTAR MARCAS
	public List<ElectrodomesticoMarca> listarMarcas() {

		List<ElectrodomesticoMarca> lst = new ArrayList<ElectrodomesticoMarca>();
		ElectrodomesticoMarca electrodomesticoMarca;
		
		String sql = "select * from marca where estado_activ = true";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				electrodomesticoMarca = new ElectrodomesticoMarca();
				electrodomesticoMarca.setId(rs.getInt("id_marca"));
				electrodomesticoMarca.setNombre(rs.getString("nombre_marca"));
				lst.add(electrodomesticoMarca);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}

		// CONSULTAR TIPOS DE ELECTRODOM?STICOS
	public List<ElectrodomesticoTipo> listarTiposE() {

		List<ElectrodomesticoTipo> lst = new ArrayList<ElectrodomesticoTipo>();
		ElectrodomesticoTipo electrodomesticoTipo;
		
		String sql = "select * from tipo_electrodomestico where estado_activ = true";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				electrodomesticoTipo = new ElectrodomesticoTipo();
				electrodomesticoTipo.setId(rs.getInt("id_tipo_electro"));
				electrodomesticoTipo.setNombre(rs.getString("nom_tipo_electro"));
				lst.add(electrodomesticoTipo);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lst;
	}
	
	public int maxId(int idPropietario) {
		int idElectro = 0;
		String sql = "SELECT MAX(id_electrodomestico) AS id FROM electrodomestico where id_propietario=?";
		cnx = getConnection();
		ResultSet rs = null;
		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idPropietario);
			rs = stm.executeQuery();

			if (rs.next()) {
				idElectro = rs.getInt(1);	
			}
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idElectro;
	}
	
	public List<DtoElectrodomesticoConsulta> listarDtoElectrodomesticosporCliente(int idPropietario) {

		List<DtoElectrodomesticoConsulta> lst = new ArrayList<DtoElectrodomesticoConsulta>();
		DtoElectrodomesticoConsulta elec = new DtoElectrodomesticoConsulta();
		
		String sql = "select * from v_electrodomesticos where id_propietario=?";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idPropietario);
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
}
