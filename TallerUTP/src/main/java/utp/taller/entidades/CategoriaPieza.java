package utp.taller.entidades;

public class CategoriaPieza {

	// ATRIBUTOS
	private int idCategoriaPieza;
	private String nomCategoria;

	// CONSTRUCTORES
	public CategoriaPieza() {}
	
	public CategoriaPieza(int idCategoriaPieza, String nomEsp) {
		this.idCategoriaPieza = idCategoriaPieza;
		this.nomCategoria = nomEsp;
	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdCategoriaPieza() {		return idCategoriaPieza;	}
	public void setIdCategoriaPiezad(int idCategoriaPieza) {		this.idCategoriaPieza = idCategoriaPieza;}
	
	public String getNomCategoria() {		return nomCategoria;	}
	public void setNomCategoria(String nomCategoria) {		this.nomCategoria = nomCategoria;	}
	
}

