package utp.taller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import utp.taller.entidades.Servicio;

public class DtoCitaConsulta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private int idAtencion;
	private String nombreCliente;
	private String nombreTecnico;
	private String distritoYdireccion;
	private Date fechaAtencion;
	private String horaAtencion;
	private Set<DtoServicioAtencion> servicios;
	private String tipoElectrodomestico;
	
	// MÉTODOS GETTER & SETTER
	public int getIdAtencion() {		return idAtencion;	}
	public void setIdAtencion(int idAtencion) {		this.idAtencion = idAtencion;	}
	
	public String getNombreTecnico() {		return nombreTecnico;	}
	public void setNombreTecnico(String nombreTecnico) {		this.nombreTecnico = nombreTecnico;	}
	
	public String getNombreCliente() {		return nombreCliente;	}
	public void setNombreCliente(String nombreCliente) {		this.nombreCliente = nombreCliente;	}

	public String getTipoElectrodomestico() {		return tipoElectrodomestico;	}
	public void setTipoElectrodomestico(String tipoElectrodomestico) {		this.tipoElectrodomestico = tipoElectrodomestico;	}

	public String getDistritoYdireccion() {		return distritoYdireccion;	}
	public void setDistritoYdireccion(String distritoCliente) {		this.distritoYdireccion = distritoCliente;	}

	public Date getFechaAtencion() {		return fechaAtencion;}
	public void setFechaAtencion(Date fechaAtencion) {		this.fechaAtencion = fechaAtencion;	}
	
	public String getHoraAtencion() {		return horaAtencion;	}
	public void setHoraAtencion(String horaAtencion) {		this.horaAtencion = horaAtencion;	}
	
	public Set<DtoServicioAtencion> getServicios() {		return servicios;	}
	public void setServicios(Set<DtoServicioAtencion> servicios) {		this.servicios = servicios;	}
	
	// MÉTODOS PÚBLICOS
	public DtoServicioAtencion getServicioPrincipal() {
		DtoServicioAtencion prin = servicios.stream().filter(s-> s.getIdServicio() !=5 && s.getIdServicio()!=9).findFirst().get();
		return prin;
	}
	
}
