package utp.taller.entidades;

public class Distrito {

	// ATRIBUTOS
	private int idDistrito;
	private String nomDistrito;

	// CONSTRUCTORES
	public Distrito() {}
	
	public Distrito(int idDistrito, String nomEsp) {
		this.idDistrito = idDistrito;
		this.nomDistrito = nomEsp;
	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdDistrito() {		return idDistrito;	}
	public void setIdDistrito(int idDistrito) {		this.idDistrito = idDistrito;	}
	
	public String getNombreDistrito() {		return nomDistrito;	}
	public void setNombreDistrito(String nomDistrito) {		this.nomDistrito = nomDistrito;	}
	
	
}
