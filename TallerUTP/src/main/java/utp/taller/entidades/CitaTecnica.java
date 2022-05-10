package utp.taller.entidades;

import java.util.Date;

public class CitaTecnica {

	// ATRIBUTOS
	private String idCita;
	private Cliente cliente;
	private Tecnico tecnica;
	private Servicio servicio;
	private Electrodomestico electrodomestico;
	private Date fechaCita;
	private String horaCita;
	private String estado;
	private String diagnostico;
	
	// CONSTRUCTORES
	public CitaTecnica() {	}

	// MÉTODOS GETTER & SETTER
	public String getIdCita() {		return idCita;	}
	public void setIdCita(String idCita) {		this.idCita = idCita;	}

	public Cliente getCliente() {		return cliente;	}
	public void setCliente(Cliente cliente) {		this.cliente = cliente;	}

	public Tecnico getTecnica() {		return tecnica;	}
	public void setTecnica(Tecnico tecnica) {		this.tecnica = tecnica;	}

	public Servicio getServicio() {		return servicio;	}
	public void setServicio(Servicio servicio) {		this.servicio = servicio;	}

	public Electrodomestico getElectrodomestico() {		return electrodomestico;	}
	public void setElectrodomestico(Electrodomestico electrodomestico) {		this.electrodomestico = electrodomestico;	}
	
	public Date getFechaCita() {		return fechaCita;	}
	public void setFechaCita(Date fechaCita) {		this.fechaCita = fechaCita;	}

	public String getHoraCita() {		return horaCita;	}
	public void setHoraCita(String horaCita) {		this.horaCita = horaCita;	}

	public String getEstado() {		return estado;	}
	public void setEstado(String estado) {		this.estado = estado;	}

	public String getDiagnostico() {		return diagnostico;	}
	public void setDiagnostico(String diagnostico) {		this.diagnostico = diagnostico;	}
	
}
