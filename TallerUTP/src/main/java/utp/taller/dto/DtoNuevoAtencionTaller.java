package utp.taller.dto;

import java.util.Date;

import utp.taller.entidades.Cliente;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.Servicio;
import utp.taller.entidades.Tecnico;

public class DtoNuevoAtencionTaller {
	// ATRIBUTOS
		private Servicio servicio;
		private Electrodomestico electrodomestico;
		private DtoHoraConsulta dtoHora;
		private Date fechaReserva;
		private String diagnostico;
		private String tipoAtencion;
		
		// CONSTRUCTORES
		public DtoNuevoAtencionTaller() {	}

		// MÉTODOS GETTER & SETTER
		public Servicio getServicio() {		return servicio;	}
		public void setServicio(Servicio servicio) {		this.servicio = servicio;	}

		public Electrodomestico getElectrodomestico() {		return electrodomestico;	}
		public void setElectrodomestico(Electrodomestico electrodomestico) {		this.electrodomestico = electrodomestico;	}
		
		public Date getFechaReserva() {		return fechaReserva;	}
		public void setFechaReserva(Date fechaCita) {		this.fechaReserva = fechaCita;	}

		public String getDiagnostico() {		return diagnostico;	}
		public void setDiagnostico(String diagnostico) {		this.diagnostico = diagnostico;	}

		public String getTipoAtencion() {	return tipoAtencion;}
		public void setTipoAtencion(String tipoAtencion) {	this.tipoAtencion = tipoAtencion;}

		public DtoHoraConsulta getDtoHora() {	return dtoHora;	}
		public void setDtoHora(DtoHoraConsulta dtoHora) {		this.dtoHora = dtoHora;	}
}
