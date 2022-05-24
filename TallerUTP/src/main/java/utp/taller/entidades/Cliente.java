package utp.taller.entidades;

import java.util.Arrays;

public class Cliente extends Persona {

	@Override
	public String toString() {
		return "Cliente [getIdUsuario()=" + getIdUsuario() + ", getIdPersona()=" + getIdPersona() + ", getNombrePrin()="
				+ getNombrePrin() + ", getNombreSec()=" + getNombreSec() + ", getApePrin()=" + getApePrin()
				+ ", getApeSec()=" + getApeSec() + ", getTipoDocumento()=" + getTipoDocumento() + ", getNroDocumento()="
				+ getNroDocumento() + ", getFoto()=" + Arrays.toString(getFoto()) + ", getTelefono()=" + getTelefono()
				+ ", getIdDistrito()=" + getIdDistrito() + ", getDireccion()=" + getDireccion() + ", getEmail()="
				+ getEmail() + ", getContrasena()=" + getContrasena() + ", isEstadoActivo()=" + isEstadoActivo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	// CONSTRUCTORES
	public Cliente() {}
	
	// MÉTODOS GETTER & SETTER
	public int getIdPersonaCliente() {	return this.getIdPersona();	}
	public void setIdPersonaCliente(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioCliente() {		return this.getIdUsuario(); }
	public void setIdUsuarioCliente(String idUsuario) {		this.setIdUsuario(idUsuario);	}

}
