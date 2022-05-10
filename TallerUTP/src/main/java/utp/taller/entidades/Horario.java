package utp.taller.entidades;

import java.util.Date;

public class Horario {

	// ATRIBUTOS
	private Date fechaAtencion;
	private String diaSemana;
	private String horaInicio, horaFin;
	
	// CONSTRUCTORES
	public Horario(){}

	// MÉTODOS GETTER & SETTER
	public Date getFechaAtencion() {		return fechaAtencion;	}
	public void setFechaAtencion(Date fechaAtencion) {		this.fechaAtencion = fechaAtencion;	}

	public String getDiaSemana() {		return diaSemana;	}
	public void setDiaSemana(String diaSemana) {		this.diaSemana = diaSemana;	}

	public String getHoraInicio() {		return horaInicio;	}
	public void setHoraInicio(String horaInicio) {		this.horaInicio = horaInicio;	}

	public String getHoraFin() {		return horaFin;	}
	public void setHoraFin(String horaFin) {		this.horaFin = horaFin;	}
	
}
