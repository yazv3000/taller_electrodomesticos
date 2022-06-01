package utp.taller.dto;

import java.io.Serializable;

public class DtoClienteConsulta extends DtoPersonaConsulta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// MÉTODOS GETTER & SETTER
	public int getIdPersonaCliente() {	return this.getIdPersona();	}
	public void setIdPersonaCliente(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioCliente() {		return this.getIdUsuario(); }
	public void setIdUsuarioCliente(String idUsuario) {		this.setIdUsuario(idUsuario);	}
	
}
