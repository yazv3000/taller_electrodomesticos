
package utp.taller.dto;

import java.io.Serializable;

public class DtoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private int idPersona;
	private String idUsuario;
	private String rol;
	private String username;
	private String email;
	private byte[] profilePic;
	
	// CONSTRUCTORES
	public DtoUsuario() {	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdPersona() {		return idPersona;	}
	public void setIdPersona(int idPersona) {		this.idPersona = idPersona;	}

	public String getIdUsuario() {		return idUsuario;	}
	public void setIdUsuario(String idUsuario) {		this.idUsuario = idUsuario;	}

	public String getRol() {		return rol;	}
	public void setRol(String rol) {		this.rol = rol;	}
	
	public String getUsername() {		return username;	}
	public void setUsername(String username) {		this.username = username;	}
	
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}

	public byte[] getProfilePic() {		return profilePic;	}
	public void setProfilePic(byte[] profilePic) {		this.profilePic = profilePic;	}
	

}