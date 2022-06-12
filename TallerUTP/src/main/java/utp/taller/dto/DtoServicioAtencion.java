package utp.taller.dto;

import java.io.Serializable;

public class DtoServicioAtencion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private int idServicio;
	private String nomServicio;
	private boolean estadoCompleto;
	
	// MÉTODOS GETTER & SETTER

	public int getIdServicio() {		return idServicio;	}
	public void setIdServicio(int idServicio) {		this.idServicio = idServicio;	}
	
	public String getNomServicio() {		return nomServicio;	}
	public void setNomServicio(String nomServicio) {		this.nomServicio = nomServicio;	}
	
	public boolean isEstadoCompleto() {		return estadoCompleto;	}
	public void setEstadoCompleto(boolean estadoCompleto) {		this.estadoCompleto = estadoCompleto;	}
	
	
}
