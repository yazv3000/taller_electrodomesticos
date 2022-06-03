package utp.taller.entidades;

public class Servicio {

	// ATRIBUTOS
	private int idServicio;
	private String nomServicio;
	private String descripcion;
	private boolean estadoActivo;
	private String rutaImgServicio;

	// CONSTRUCTORES
	public Servicio() {}

	// MÉTODOS GETTER & SETTER
	public int getIdServicio() {		return idServicio;	}
	public void setIdServicio(int idServicio) {		this.idServicio = idServicio;	}

	public String getNomServicio() {		return nomServicio;	}
	public void setNomServicio(String nomServicio) {		this.nomServicio = nomServicio;	}

	public String getDescripcion() {		return descripcion;	}
	public void setDescripcion(String descripcion) {		this.descripcion = descripcion;	}

	public boolean isEstadoActivo() 		{return estadoActivo;	}
	public void setEstadoActivo(boolean estadoActivo)		{this.estadoActivo = estadoActivo;}

	public String getRutaImgServicio() {		return rutaImgServicio;	}
	public void setRutaImgServicio(String rutaImgServicio) {		this.rutaImgServicio = rutaImgServicio;	}
	
}
