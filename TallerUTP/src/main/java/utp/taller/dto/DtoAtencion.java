package utp.taller.dto;

import java.util.Date;

import utp.taller.entidades.Atencion;
import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Servicio;

public class DtoAtencion {

	// ATRIBUTOS
	private String idAtencion;
	private DtoClienteConsulta cliente;
	private Servicio servicio;
	private Electrodomestico electrodomestico;
	private Atencion atencion;
	private Date fechaCita;
	private Date fechaReservaCita;
	private String horaCita;
	
	
	private ElectrodomesticoTipo electrodomesticoTipo;
	private ElectrodomesticoMarca electrodomesticoMarca;
	private String tipoAtencion;
	private String fallaDescrita;
	
	// CONSTRUCTORES
	public DtoAtencion() {	}

	// MÉTODOS GETTER & SETTER
	public String getIdCita() {		return idAtencion;	}
	public void setIdCita(String idCita) {		this.idAtencion = idCita;	}

	public DtoClienteConsulta getCliente() {		return cliente;	}
	public void setCliente(DtoClienteConsulta cliente) {		this.cliente = cliente;	}

	public Servicio getServicio() {		return servicio;	}
	public void setServicio(Servicio servicio) {		this.servicio = servicio;	}

	public Atencion getAtencion() {		return atencion;	}
	public void setAtencion(Atencion atencion) {		this.atencion = atencion;	}
	
	public Electrodomestico getElectrodomestico() {		return electrodomestico;	}
	public void setElectrodomestico(Electrodomestico electrodomestico) {		this.electrodomestico = electrodomestico;	}

	public ElectrodomesticoTipo getElectrodomesticoTipo() {	return electrodomesticoTipo;}
	public void setElectrodomesticoTipo(ElectrodomesticoTipo electrodomesticoTipo) {this.electrodomesticoTipo = electrodomesticoTipo;}

	public ElectrodomesticoMarca getElectrodomesticoMarca() {return electrodomesticoMarca;}
	public void setElectrodomesticoMarca(ElectrodomesticoMarca electrodomesticoMarca) {	this.electrodomesticoMarca = electrodomesticoMarca;	}

	
	
	public String getIdAtencion() {	return idAtencion;	}
	public void setIdAtencion(String idAtencion) {	this.idAtencion = idAtencion;	}

	public Date getFechaReservaCita() {	return fechaReservaCita;}
	public void setFechaReservaCita(Date fechaReservaCita) {	this.fechaReservaCita = fechaReservaCita;	}

	public Date getFechaCita() {		return fechaCita;	}
	public void setFechaCita(Date fechaCita) {		this.fechaCita = fechaCita;	}

	public String getHoraCita() {		return horaCita;	}
	public void setHoraCita(String horaCita) {		this.horaCita = horaCita;	}

	public String getTipoAtencion() {	return tipoAtencion;}
	public void setTipoAtencion(String tipoAtencion) {	this.tipoAtencion = tipoAtencion;}

	public String getFallaDescrita() {	return fallaDescrita;	}
	public void setFallaDescrita(String fallaDescrita) {	this.fallaDescrita = fallaDescrita;	}
			
}
