package utp.taller.entidades;

public class Cliente extends Persona {

	// CONSTRUCTORES
	public Cliente() {}
	
	// MÉTODOS GETTER & SETTER
	public int getIdPersonaCliente() {	return this.getIdPersona();	}
	public void setIdPersonaCliente(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioCliente() {		return this.getIdUsuario(); }
	public void setIdUsuarioCliente(String idUsuario) {		this.setIdUsuario(idUsuario);	}

}
