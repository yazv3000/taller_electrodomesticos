package utp.taller.entidades;

public class Cliente extends Persona {

	// CONSTRUCTORES
	public Cliente() {}
	
	public Cliente(String idCliente, String nombre, String apePrin, String apeSec, String nro_doc, String telefono, String direccion, String email,
			String contrasena) {
		super(idCliente, nombre, apePrin, apeSec, nro_doc, telefono, direccion, email, contrasena);
	}

	// M�TODOS GETTER & SETTER
	public String getIdCliente() {		return this.getIdPersona(); }
	public void setIdCliente(String idCliente) {		this.setIdPersona(idCliente);	}

}
