package utp.taller.dto;

public class DtoClienteConsulta extends DtoPersonaConsulta{

	// M�TODOS GETTER & SETTER
	public String getIdCliente() {		return this.getIdUsuario(); }
	public void setIdCliente(String idCliente) {		this.setIdUsuario(idCliente);	}
	
}
