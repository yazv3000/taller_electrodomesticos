package utp.taller.entidades;

import java.util.Date;

public class Horario {

		// ATRIBUTOS
		private int idHorario;
		private int idTecnico;
		private Date fechaAtencion;
		private String diaSemana;
		private String horaInicio;
		private String estado;
		
		// CONSTRUCTORES
		public Horario(){}
		
		// MÉTODOS GETTER & SETTER
		public int getIdHorario() {		return idHorario;	}
		public void setIdHorario(int idHorario) {		this.idHorario = idHorario;	}

		public int getIdTecnico() {		return idTecnico;	}
		public void setIdTecnico(int idTecnico) {		this.idTecnico = idTecnico;	}

		public Date getFechaAtencion() {		return fechaAtencion;	}
		public void setFechaAtencion(Date fechaAtencion) {		this.fechaAtencion = fechaAtencion;	}

		public String getDiaSemana() {		return diaSemana;	}
		public void setDiaSemana(String diaSemana) {		this.diaSemana = diaSemana;	}

		public String getHoraInicio() {		return horaInicio;	}
		public void setHoraInicio(String horaInicio) {		this.horaInicio = horaInicio;	}

		public String getEstado() {	return estado;}
		public void setEstado(String estado) {	this.estado = estado;}
	
}
