package utp.taller.entidades;

public class Encargado extends Usuario{

	// ATRIBUTOS
	private String idEncargado;

    // CONSTRUCTORES
	public Encargado() {}

    public Encargado(String idEncargado, String email, String contrasena) {
		super(email, contrasena);
		this.idEncargado = idEncargado;
	}

	// MÉTODOS GETTER & SETTER
	public String getIdEncargado() {
		return idEncargado;
	}

	public void setIdEncargado(String idEncargado) {
		this.idEncargado = idEncargado;
	}


}