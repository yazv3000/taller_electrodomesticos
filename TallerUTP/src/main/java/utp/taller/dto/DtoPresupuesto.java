package utp.taller.dto;

public class DtoPresupuesto {
	//ATRIBUTOS
	private String nombre;
	private String servicio;
	private String precio;
	
	public DtoPresupuesto() {}
	
	public String getNombre() {	return nombre;}
	public void setNombre(String nombre) {	this.nombre = nombre;	}
	
	public String getServicio() {	return servicio == null ? "---" : servicio;	}
	public void setServicio(String servicio) {	this.servicio = servicio;	}
		
	public String getPrecio() {	return precio;}
	public void setPrecio(String precio) {		this.precio = "S/."+precio;}
	
	
}
