package utp.taller.dto;

public abstract class DtoPersonaConsulta {

	// ATRIBUTOS
	private String idUsuario;
	private int idPersona;
	private String nombreCompleto;
	private String telefono;
	private String distrito;
	private String direccion;
	private String email;
	
	// M�TODOS GETTER & SETTER
	public String getIdUsuario() {return idUsuario;	}
	public void setIdUsuario(String idUsuario) {		this.idUsuario = idUsuario;	}
	
	public int getIdPersona() {			return idPersona;		}
	public void setIdPersona(int idPersona) {			this.idPersona = idPersona;		}
	
	public String getNombreCompleto() { return nombreCompleto;	}
	public void setNombreCompleto(String nombreCompleto) {		this.nombreCompleto = nombreCompleto;	}
	
	public String getTelefono() {		return telefono;	}
	public void setTelefono(String telefono) {		this.telefono = telefono;	}
	
	public String getDistrito() {	return distrito;}
	public void setDistrito(String distrito) {	this.distrito = distrito;}
	
	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}
	
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	
}
