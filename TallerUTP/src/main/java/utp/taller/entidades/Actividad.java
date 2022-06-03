package utp.taller.entidades;

public class Actividad {
	
	// ATRIBUTOS
    private int idActividad;
    private String nombre;
    private double precio;
    
	// CONSTRUCTOR
    public Actividad() { }

	// MÉTODOS GETTER & SETTER
	public int getIdActividad() {		return idActividad;	}
	public void setIdActividad(int idActividad) {		this.idActividad = idActividad;	}

	public String getNombre() {		return nombre;	}
	public void setNombre(String nombre) {		this.nombre = nombre;	}

	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}
    
    
}
