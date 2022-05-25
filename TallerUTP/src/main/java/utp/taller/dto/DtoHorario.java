package utp.taller.dto;

import java.util.Date;

public class DtoHorario {

	// ATRIBUTOS
	private int idHorario;
	private int idTecnico;
	private Date fechaAtencion;
	private String diaSemana;
	private String horaInicio, horaFin;
	private int estado;
	
	// CONSTRUCTORES
	public DtoHorario(){}
	
	// MÉTODOS GETTER & SETTER
	public int getIdHorario() {		return idHorario;	}
	public void setIdHorario(int idHorario) {		this.idHorario = idHorario;	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Date getFechaAtencion() {		return fechaAtencion;	}
	public void setFechaAtencion(Date fechaAtencion) {		this.fechaAtencion = fechaAtencion;	}

	public String getDiaSemana() {		return diaSemana;	}
	public void setDiaSemana(String diaSemana) {		this.diaSemana = diaSemana;	}

	public String getHoraInicio() {		return horaInicio;	}
	public void setHoraInicio(String horaInicio) {		this.horaInicio = horaInicio;	}

	public String getHoraFin() {		return horaFin;	}
	public void setHoraFin(String horaFin) {		this.horaFin = horaFin;	}

	@Override
	public String toString() {
		return "DtoHorario [idHorario=" + idHorario + ", idTecnico=" + idTecnico + ", fechaAtencion=" + fechaAtencion
				+ ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
