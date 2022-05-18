package utp.taller.entidades;

public class Cliente extends Persona {

	// CONSTRUCTORES
	public Cliente() {}
	
	public Cliente(String idCliente, String nombrePrin, String nombreSec, String apePrin, String apeSec, String nro_doc, String telefono, String direccion, String email,
			String contrasena) {
		super(idCliente, nombrePrin, nombreSec, apePrin, apeSec, nro_doc, telefono, direccion, email, contrasena);
	}

	// MÉTODOS GETTER & SETTER
	public String getIdCliente() {		return this.getIdPersona(); }
	public void setIdCliente(String idCliente) {		this.setIdPersona(idCliente);	}

}
