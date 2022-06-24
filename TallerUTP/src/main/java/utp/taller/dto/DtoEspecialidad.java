package utp.taller.dto;

public class DtoEspecialidad {

	// ATRIBUTOS
	private int idEspecialidad;
	private String nomEsp;
	private boolean seleccionado;

	// CONSTRUCTORES
	public DtoEspecialidad() {}
	
	public DtoEspecialidad(int idEspecialidad, String nomEsp) {
		this.idEspecialidad = idEspecialidad;
		this.nomEsp = nomEsp;
	}
	
	// MÉTODOS GETTER & SETTER
	public int getIdEspecialidad() {		return idEspecialidad;	}
	public void setIdEspecialidad(int idEspecialidad) {		this.idEspecialidad = idEspecialidad;	}
	
	public String getNomEsp() {		return nomEsp;	}
	public void setNomEsp(String nomEsp) {		this.nomEsp = nomEsp;	}

	public boolean isSeleccionado() {		return seleccionado;	}
	public void setSeleccionado(boolean seleccionado) {		this.seleccionado = seleccionado;	}
	
}
