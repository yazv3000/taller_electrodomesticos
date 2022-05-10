package utp.taller.entidades;

public class Servicio {

	// ATRIBUTOS
	private int idServicio;
	private String nomServicio;
	private double precio;
	private int duracion;
	private String descripcion;

	// CONSTRUCTORES
	public Servicio() {}

	public Servicio(int idServicio, String nomServicio, double precio, int duracion, String descripcion) {
		this.idServicio = idServicio;
		this.nomServicio = nomServicio;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	// MÉTODOS GETTER & SETTER
	public int getIdServicio() {		return idServicio;	}
	public void setIdServicio(int idServicio) {		this.idServicio = idServicio;	}

	public String getNomServicio() {		return nomServicio;	}
	public void setNomServicio(String nomServicio) {		this.nomServicio = nomServicio;	}

	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}

	public int getDuracion() {		return duracion;	}
	public void setDuracion(int duracion) {		this.duracion = duracion;	}

	public String getDescripcion() {		return descripcion;	}
	public void setDescripcion(String descripcion) {		this.descripcion = descripcion;	}
	
}
