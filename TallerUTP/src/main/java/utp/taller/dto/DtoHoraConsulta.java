package utp.taller.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DtoHoraConsulta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private int idHorario;
	private String nombreTecnico;
	private String telefonoTecnico;
	private String fotoTecnico;
	private String especialidad;
	private Date fecha;
	private String hora;

	// CONSTRUCTORES
	public DtoHoraConsulta() {	}
	
	// MÉTODOS PÚBLICOS
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

	// MÉTODOS GETTER & SETTER
	public int getIdHorario() {		return idHorario;	}
	public void setIdHorario(int idHorario) {		this.idHorario = idHorario;	}
	
	public String getNombreTecnico() {	return nombreTecnico;	}
	public void setNombreTecnico(String nombres) {		this.nombreTecnico = nombres;	}

	public String getEspecialidad() {		return especialidad;	}
	public void setEspecialidad(String especialidad) {		this.especialidad = especialidad;	}

	public String getTelefonoTecnico() {		return telefonoTecnico;	}
	public void setTelefonoTecnico(String telefono) {		this.telefonoTecnico = telefono;	}

	public Date getFecha() {		return fecha;	}
	public void setFecha(Date fecha) {		this.fecha = fecha;	}

	public String getHora() {		return hora;	}
	public void setHora(String hora) {		this.hora = hora;	}

	public String getFotoTecnico() {		return fotoTecnico;	}
	public void setFotoTecnico(String fotoTecnico) {		this.fotoTecnico = fotoTecnico;	}
	
}
