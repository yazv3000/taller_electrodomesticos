package utp.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.dto.DtoTecnicoConsulta;
import utp.taller.entidades.Tecnico;

public class DaoTecnico extends Conexion implements BaseDAO<Tecnico> {

	Connection cnx = null;
	PreparedStatement stm = null;
	
	public List<DtoTecnicoConsulta> listarDtoTecnicos(){
		List<DtoTecnicoConsulta> lst = new ArrayList<DtoTecnicoConsulta>();
		DtoTecnicoConsulta tc = null;
		String sql = "select * from f_listar_tecnicos()";
		
		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				tc = new DtoTecnicoConsulta();
				tc.setIdPersona(rs.getInt(1));
				tc.setIdTecnico(rs.getString(2));
				tc.setNombreCompleto(rs.getString(3));
				tc.setTelefono(rs.getString(4));
				tc.setDireccion(rs.getString(5));
				tc.setEmail(rs.getString(6));
				lst.add(tc);
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;

	}

	@Override
	public Tecnico consultarId(int idTecnico) {

		Tecnico t = null;

		String sql = "select * from f_consultar_tecnico(?)";

		cnx = getConnection();
		ResultSet rs = null;

		try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idTecnico);
			rs = stm.executeQuery();

			if (rs.next()) {
				t = new Tecnico();
				t.setIdTecnico(rs.getString(1));
				t.setNombrePrin(rs.getString(2));
				t.setNombreSec(rs.getString(3));
				t.setApePrin(rs.getString(4));
				t.setApeSec(rs.getString(5));
				t.setTipo_doc(rs.getInt(6));
				t.setNro_doc(rs.getString(7));
				t.setTelefono(rs.getString(8));
				t.setDireccion(rs.getString(10));
				t.setAnios_experiencia(rs.getInt(11));
				t.setEmail(rs.getString(12));
				t.setContrasena(rs.getString(13));
			}
			
			cnx.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}

	@Override
	public int insertar(Tecnico t) {
		String sql = "insert into tecnico(nom_tec, ape1_tec, ape2_tec, id_tdoc, nro_doc, direccion, experiencia, email_tec, contra_tec) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, t.getNombrePrin());
			stm.setString(2, t.getNombreSec());
			stm.setString(3, t.getApePrin());
			stm.setString(4, t.getApeSec());
			stm.setInt(5, 1);		// 1 = dni
			stm.setString(6, t.getNro_doc());
			stm.setString(7, t.getDireccion());
			stm.setInt(8, t.getAnios_experiencia());
			stm.setString(9, t.getEmail());
			stm.setString(10, t.getContrasena());
			
			stm.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int modificar(Tecnico t) {
		String sql = "update tecnico set nom_tec=?, ape1_tec=?, ape2_tec=?, id_tdoc=?, nro_doc=?, direccion=?, experiencia=?, email_tec=?, contra_tec=? where id_tecnico=?";
		cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			stm = cnx.prepareStatement(sql);
			stm.setString(1, t.getNombrePrin());
			stm.setString(2, t.getNombreSec());
			stm.setString(3, t.getApePrin());
			stm.setString(4, t.getApeSec());
			stm.setInt(5, 1);		// 1 = dni
			stm.setString(6, t.getNro_doc());
			stm.setString(7, t.getDireccion());
			stm.setInt(8, t.getAnios_experiencia());
			stm.setString(9, t.getEmail());
			stm.setString(10, t.getContrasena());
			//stm.setInt(10, t.getIdTecnico());
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
		
		String sql = "delete from tecnico where id_tecnico=?";
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
}
