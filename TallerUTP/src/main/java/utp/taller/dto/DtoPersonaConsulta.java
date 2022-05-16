package utp.taller.dto;

public abstract class DtoPersonaConsulta {

	// ATRIBUTOS
	private String idPersona;
	private String nombreCompleto;
	private String telefono;
	private String direccion;
	private String email;
	
	// MÉTODOS GETTER & SETTER
	public String getIdPersona() {			return idPersona;		}
	public void setIdPersona(String idPersona) {			this.idPersona = idPersona;		}
	
	public String getNombreCompleto() { return nombreCompleto;	}
	public void setNombreCompleto(String nombreCompleto) {		this.nombreCompleto = nombreCompleto;	}
	
	public String getTelefono() {		return telefono;	}
	public void setTelefono(String telefono) {		this.telefono = telefono;	}
	
	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}
	
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	
}
