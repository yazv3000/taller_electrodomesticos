package utp.taller.entidades;

import java.util.HashSet;
import java.util.Set;

public class Cliente extends Usuario {

	// ATRIBUTOS
	private int idCliente;
	private String nombre, apePrin, apeSec;
	private String nro_doc;
	private Set<String> telefonos;
	private String direccion;
	
	// CONSTRUCTORES
	public Cliente() {}
	
	public Cliente(int idCliente, String nombre, String apePrin, String apeSec, String nro_doc, String direccion, String email, String contrasena) {
		super(email, contrasena);
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apePrin = apePrin;
		this.apeSec = apeSec;
		this.nro_doc = nro_doc;
		this.direccion = direccion;
		telefonos = new HashSet<String>();
	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdCliente() {		return idCliente; }
	public void setIdCliente(int idCliente) {		this.idCliente = idCliente;	}
	
	public String getNombre() {		return nombre;	}
	public void setNombre(String nombre) {		this.nombre = nombre;	}
	
	public String getApePrin() {		return apePrin;	}
	public void setApePrin(String apePrin) {		this.apePrin = apePrin;	}

	public String getApeSec() {		return apeSec;	}
	public void setApeSec(String apeSec) {		this.apeSec = apeSec;	}

	public String getNro_doc() {		return nro_doc;	}
	public void setNro_doc(String nro_doc) {		this.nro_doc = nro_doc;	}
	
	// falta set teléfono
	public Set<String> getTelefonos() {		return telefonos;	}

	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}
	
}
