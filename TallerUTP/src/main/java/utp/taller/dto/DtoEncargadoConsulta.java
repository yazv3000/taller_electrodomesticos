package utp.taller.dto;

public class DtoEncargadoConsulta extends DtoPersonaConsulta{

	// MÉTODOS GETTER & SETTER
	public int getIdPersonaEncargado() {	return this.getIdPersona();	}
	public void setIdPersonaEncargado(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioEncargado() {		return this.getIdUsuario(); }
	public void setIdUsuarioEncargado(String idUsuario) {		this.setIdUsuario(idUsuario);	}
	
}
