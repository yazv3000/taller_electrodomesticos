package utp.taller.dto;

public class DtoClienteConsulta extends DtoPersonaConsulta{

	// MÉTODOS GETTER & SETTER
	public int getIdPersonaCliente() {	return this.getIdPersona();	}
	public void setIdPersonaCliente(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioCliente() {		return this.getIdUsuario(); }
	public void setIdUsuarioCliente(String idUsuario) {		this.setIdUsuario(idUsuario);	}
	
}
