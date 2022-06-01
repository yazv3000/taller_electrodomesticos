package utp.taller.entidades;

import java.util.Date;

public class Atencion {
	private int id;
	private int idElectro;
	private int idHorario;
	private Date fechaReserva;
	private String lugar;
	private String estAtencion;
	private int presupuesto;
	private int montoTotal;
	private boolean estActivacion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdElectro() {
		return idElectro;
	}
	public void setIdElectro(int idElectro) {
		this.idElectro = idElectro;
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public Date getfechaReserva() {
		return fechaReserva;
	}
	public void setfechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getEstAtencion() {
		return estAtencion;
	}
	public void setEstAtencion(String estAtencion) {
		this.estAtencion = estAtencion;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public int getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}
	public boolean isestActivacion() {
		return estActivacion;
	}
	public void setestActivacion(boolean estActivacion) {
		this.estActivacion = estActivacion;
	}
	
	

}
