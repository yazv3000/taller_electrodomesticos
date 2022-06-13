package utp.taller.dto;

import java.io.Serializable;
import java.util.Date;

import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.Servicio;

public class DtoNuevaCita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private Servicio servicio;
	private Electrodomestico electrodomestico;
	private DtoHoraConsulta dtoHora;
	private Date fechaReserva;
	private String lugar;
	private String fallaElectrodomestico;

	// CONSTRUCTORES
	public DtoNuevaCita() {	}
	
	// MÉTODOS GETTER & SETTER
	public Servicio getServicio() {		return servicio;	}
	public void setServicio(Servicio servicio) {		this.servicio = servicio;	}
	
	public Electrodomestico getElectrodomestico() {		return electrodomestico;	}
	public void setElectrodomestico(Electrodomestico electrodomestico) {		this.electrodomestico = electrodomestico;	}

	public DtoHoraConsulta getDtoHora() {		return dtoHora;	}
	public void setDtoHora(DtoHoraConsulta dtoHora) {		this.dtoHora = dtoHora;	}

	public Date getFechaReserva() {		return fechaReserva;	}
	public void setFechaReserva(Date fechaReserva) {		this.fechaReserva = fechaReserva;	}

	public String getLugar() {		return lugar;	}
	public void setLugar(String lugar) {		this.lugar = lugar;	}

	public String getFallaElectrodomestico() {		return fallaElectrodomestico;	}
	public void setFallaElectrodomestico(String fallaElectrodomestico) {		this.fallaElectrodomestico = fallaElectrodomestico;	}

	@Override
	public String toString() {
		return "DtoNuevaCita [servicio=" + servicio + ", electrodomestico=" + electrodomestico + ", dtoHora=" + dtoHora
				+ ", fechaReserva=" + fechaReserva + ", lugar=" + lugar + ", fallaElectrodomestico="
				+ fallaElectrodomestico + "]";
	}
	
}
