package utp.taller.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DtoReporteConsulta {

	// ATRIBUTOS
	private int idAtencion;
	private Date fecha;
	private String fechaString;
	private String nombreTecnico;
	private String nombreCliente;
	private String electrodomestico;
	private String marca;
	private String servicio;
	private double monto;
	//TODO FALTA AGREGAR LA hora de atencion: String hora
	// CONSTRUCTORES
	public DtoReporteConsulta() {}

	// MÉTODOS GETTER & SETTER
	public int getIdAtencion() {		return idAtencion;	}
	public void setIdAtencion(int idAtencion) {		this.idAtencion = idAtencion;	}

	public Date getFecha() {		return fecha;	}
	public void setFecha(Date fecha) {		this.fecha = fecha;	}

	public String getNombreTecnico() {		return nombreTecnico;	}
	public void setNombreTecnico(String nombreTecnico) {		this.nombreTecnico = nombreTecnico;	}

	public String getNombreCliente() {		return nombreCliente;	}
	public void setNombreCliente(String nombreCliente) {		this.nombreCliente = nombreCliente;}

	public String getElectrodomestico() {		return electrodomestico;	}
	public void setElectrodomestico(String electrodomestico) {		this.electrodomestico = electrodomestico;	}

	public String getMarca() {		return marca;	}
	public void setMarca(String marca) {		this.marca = marca;	}

	public String getServicio() {		return servicio;	}
	public void setServicio(String servicio) {		this.servicio = servicio;	}
	 
	public double getMonto() {		return monto;	}
	public void setMonto(double monto) {		this.monto = monto;	}
	
	public String getFechaString() { 	
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		return form.format(fecha);	}

	
}
