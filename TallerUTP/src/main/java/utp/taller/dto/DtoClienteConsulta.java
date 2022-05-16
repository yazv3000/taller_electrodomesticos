package utp.taller.dto;

public class DtoClienteConsulta extends DtoPersonaConsulta{

	// MÉTODOS GETTER & SETTER
	public String getIdTecnico() {			return this.getIdPersona();		}
	public void setIdTecnico(String idTecnico) {			this.setIdPersona(idTecnico);		}

	// MÉTODOS GETTER & SETTER
	public String getIdCliente() {		return this.getIdPersona(); }
	public void setIdCliente(String idCliente) {		this.setIdPersona(idCliente);	}
	
}
