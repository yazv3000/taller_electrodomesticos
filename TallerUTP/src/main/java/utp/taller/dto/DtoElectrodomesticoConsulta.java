package utp.taller.dto;

public class DtoElectrodomesticoConsulta {
	
    // ATRIBUTOS
	private int idElectrodomestico;
	private String nroSerie;
	private String tipo;
	private String modelo;
	private String marca;
	private String nombrePropietario;
	private boolean estadoActivo;

    // MÉTODOS GETTER & SETTER
	public int getIdElectrodomestico() {	return idElectrodomestico;}
	public void setIdElectrodomestico(int idElectrodomestico) {	this.idElectrodomestico = idElectrodomestico;	}
	
	public String getNroSerie() {	return nroSerie;	}
	public void setNroSerie(String nroSerie) {	this.nroSerie = nroSerie;}
	
	public String getTipo() {	return tipo;}
	public void setTipo(String tipo) {this.tipo = tipo;	}
	
	public String getModelo() {		return modelo;	}
	public void setModelo(String modelo) {	this.modelo = modelo;}
	
	public String getMarca() {return marca;	}
	public void setMarca(String marca) {this.marca = marca;	}
	
	public String getNombrePropietario() {	return nombrePropietario;}
	public void setNombrePropietario(String nombrePropietario) {	this.nombrePropietario = nombrePropietario;	}
	
	public boolean isEstadoActivo() {	return estadoActivo;}
	public void setEstadoActivo(boolean estadoActivo) {	this.estadoActivo = estadoActivo;	}



}
