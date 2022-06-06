package utp.taller.dto;

import java.util.List;

import utp.taller.entidades.Actividad;

public class DtoServicioActividades {

	// ATRIBUTOS
	private int idServicio;
	private String nomServicio;
	private List<Actividad> actidades;
	
	// CONSTRUCTOR
	public DtoServicioActividades() {}

	// MÉTODOS GETTER & SETTER
	public int getIdServicio() {		return idServicio;	}
	public void setIdServicio(int idServicio) {		this.idServicio = idServicio;	}

	public String getNomServicio() {		return nomServicio;	}
	public void setNomServicio(String nomServicio) {		this.nomServicio = nomServicio;	}

	public List<Actividad> getActidades() {		return actidades;	}
	public void setActidades(List<Actividad> actidades) {		this.actidades = actidades;	}
	
}
