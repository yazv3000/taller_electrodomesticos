package utp.taller.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DtoConsultaCita {

	// ATRIBUTOS
	private int idHorario;
	private String nombres;
	private String especialidad;
	private String telefono;
	private String servicio;
	private Date fecha;
	private String hora;
	private String estado;
	private String lugar;

	// CONSTRUCTORES
	public DtoConsultaCita() {
	}
	
	// M�TODOS
	public String getFormatoFecha() {
		LocalDate diaMes = null;
		ZoneId timeZone = ZoneId.systemDefault();
		Date f = getFecha();
		diaMes = f.toInstant().atZone(timeZone).toLocalDate();
		return diaMes.getDayOfMonth() + " de " +mes(diaMes.getMonthValue())  + " del " +diaMes.getYear();
	}
	
	public String mes(int numMes) {
		String m;
		switch (numMes) {
		case 1: m = "Enero"; break;
		case 2: m = "Febrero"; break;
		case 3: m = "Marzo"; break;
		case 4: m = "Abril"; break;
		case 5: m = "Mayo"; break;
		case 6: m = "Junio"; break;
		case 7: m = "Julio"; break;
		case 8: m = "Agosto"; break;
		case 9: m = "Setiembre"; break;
		case 10: m = "Octubre"; break;
		case 11: m = "Noviembre"; break;
		case 12: m = "Diciembre"; break;
		default: m = null; break;
		}
		
		return m;
	}
	
	// M�TODOS GETTER & SETTER
	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
		
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
}
