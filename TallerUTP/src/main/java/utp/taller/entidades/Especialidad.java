package utp.taller.entidades;

public class Especialidad {

	// ATRIBUTOS
	private int idEspecialidad;
	private String nomEsp;

	// CONSTRUCTORES
	public Especialidad() {}
	
	public Especialidad(int idEspecialidad, String nomEsp) {
		this.idEspecialidad = idEspecialidad;
		this.nomEsp = nomEsp;
	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdEspecialidad() {		return idEspecialidad;	}
	public void setIdEspecialidad(int idEspecialidad) {		this.idEspecialidad = idEspecialidad;	}
	
	public String getNomEsp() {		return nomEsp;	}
	public void setNomEsp(String nomEsp) {		this.nomEsp = nomEsp;	}
	
	
}
