package utp.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {
	public static Connection getConnection() {
        Connection cnx = null;
        try {
            Context ctx = new InitialContext(); 
            DataSource ds = (DataSource)ctx.lookup("java:/jdbc/taller_utp"); 
            cnx = ds.getConnection();
        } catch (SQLException e) {
        	System.out.println("Excepcional");
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e); 
        }
        return cnx;
    }

}
