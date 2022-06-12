package utp.taller.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.config.Conexion;
import utp.taller.entidades.Actividad;

public class DaoActividad extends Conexion{
    Connection cnx = null;
	PreparedStatement stm = null;
	
    public List<Actividad> listarActividades(int idServicio){
        List<Actividad> lst = new ArrayList<Actividad>();
        Actividad actividad = null;
        String sql = "select * from actividades_servicio where id_servicio = ?";
        cnx = getConnection();
		ResultSet rs = null;
        try {
			stm = cnx.prepareStatement(sql);
			stm.setInt(1, idServicio);
			rs = stm.executeQuery();

			while (rs.next()) {
                actividad = new Actividad();
				actividad.setIdActividad(rs.getInt("id_actividad"));
                actividad.setNombre(rs.getString("nombre_actividad"));
                actividad.setPrecio(rs.getBigDecimal("precio").doubleValue());
                lst.add(actividad);
			}	
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        return lst;
    }
    public int agregar_actividad_servicio(int idAtencion, int idServicio, List<Actividad> listaActividades) {
		String sql = "call sp_agregar_actividad(?, ?, ?)";
		cnx = getConnection();
		try {
			for (Actividad a : listaActividades) {
				stm = cnx.prepareStatement(sql);
				stm.setInt(1, idAtencion);
				stm.setInt(2, idServicio);
				stm.setInt(3, a.getIdActividad());
				stm.execute();
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
}