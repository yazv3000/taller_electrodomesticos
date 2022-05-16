package utp.taller.entidades;

public class Encargado extends Persona{

    // CONSTRUCTORES
	public Encargado() {}

	public Encargado(String idEncargado, String nombre, String apePrin, String apeSec, String nro_doc, String telefono, String direccion, String email,
			String contrasena) {
		super(idEncargado, nombre, apePrin, apeSec, nro_doc, telefono, direccion, email, contrasena);
	}

	// MÉTODOS GETTER & SETTER
	public String getIdEncargado() { 
		return this.getIdPersona(); 
	}

	public void setIdEncargado(String idEncargado) {
		this.setIdPersona(idEncargado);
	}


}