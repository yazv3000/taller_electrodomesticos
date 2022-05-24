package utp.taller.entidades;

public class CategoriaPieza {

	// ATRIBUTOS
	private int idCategoriaPieza;
	private String nombreCategoria;

	// CONSTRUCTORES
	public CategoriaPieza() {}
	
	public CategoriaPieza(int idCategoriaPieza, String nomCat) {
		this.idCategoriaPieza = idCategoriaPieza;
		this.nombreCategoria = nomCat;
	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdCategoria() {		return idCategoriaPieza;	}
	public void setIdCategoria(int idCategoriaPieza) {		this.idCategoriaPieza = idCategoriaPieza;}
	
	public String getNombreCat() {		return nombreCategoria;	}
	public void setNombreCat(String nomCategoria) {		this.nombreCategoria = nomCategoria;	}
	
}

