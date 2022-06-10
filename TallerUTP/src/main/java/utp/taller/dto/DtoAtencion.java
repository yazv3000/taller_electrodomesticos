package utp.taller.dto;

import java.io.Serializable;
import java.util.Date;

import utp.taller.entidades.Electrodomestico;
import utp.taller.entidades.ElectrodomesticoMarca;
import utp.taller.entidades.ElectrodomesticoTipo;
import utp.taller.entidades.Servicio;

public class DtoAtencion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private int idAtencion;
	private DtoClienteConsulta cliente;
	private Servicio servicio;
	private Electrodomestico electrodomestico;
	private Date fechaCita;
	private Date fechaReservaCita;
	private String horaCita;
	
	private ElectrodomesticoTipo electrodomesticoTipo;
	private ElectrodomesticoMarca electrodomesticoMarca;
	private String tipoAtencion;
	private String fallaDescrita;
	private String estado;

	// CONSTRUCTORES
	public DtoAtencion() {	}

	// MÉTODOS GETTER & SETTER
	public int getIdAtencion() {	return idAtencion;}
	public void setIdAtencion(int idAtencion) {	this.idAtencion = idAtencion;	}

	public DtoClienteConsulta getCliente() {		return cliente;	}
	public void setCliente(DtoClienteConsulta cliente) {		this.cliente = cliente;	}

	public Servicio getServicio() {		return servicio;	}
	public void setServicio(Servicio servicio) {		this.servicio = servicio;	}
	
	public Electrodomestico getElectrodomestico() {		return electrodomestico;	}
	public void setElectrodomestico(Electrodomestico electrodomestico) {		this.electrodomestico = electrodomestico;	}

	public ElectrodomesticoTipo getElectrodomesticoTipo() {	return electrodomesticoTipo;}
	public void setElectrodomesticoTipo(ElectrodomesticoTipo electrodomesticoTipo) {this.electrodomesticoTipo = electrodomesticoTipo;}

	public ElectrodomesticoMarca getElectrodomesticoMarca() {return electrodomesticoMarca;}
	public void setElectrodomesticoMarca(ElectrodomesticoMarca electrodomesticoMarca) {	this.electrodomesticoMarca = electrodomesticoMarca;	}

	public String getEstado() {	return estado;}
	public void setEstado(String estado) {	this.estado = estado;}

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
