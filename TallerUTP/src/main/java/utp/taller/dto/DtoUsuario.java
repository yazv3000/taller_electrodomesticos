
package utp.taller.dto;

public class DtoUsuario {

	private String correo;
	private String contra;

	public DtoUsuario() {}

	public DtoUsuario(String correo, String contra) {
		this.correo = correo;
		this.contra = contra;
	}

	public String getCorreo() {		return correo;	}
	public void setCorreo(String correo) {		this.correo = correo;	}
	
	public String getContra() {		return contra;	}
	public void setContra(String contra) {		this.contra = contra;	}

}