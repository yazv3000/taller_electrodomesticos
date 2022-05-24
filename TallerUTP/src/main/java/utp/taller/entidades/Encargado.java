package utp.taller.entidades;

public class Encargado extends Persona{

    // CONSTRUCTORES
	public Encargado() {}

	// MÉTODOS GETTER & SETTER
	public int getIdPersonaEncargado() {	return this.getIdPersona();	}
	public void setIdPersonaEncargado(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioEncargado() {		return this.getIdUsuario(); }
	public void setIdUsuarioEncargado(String idUsuario) {		this.setIdUsuario(idUsuario);	}

}