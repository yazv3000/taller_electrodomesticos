package utp.taller.entidades;

import java.util.Set;

public class Recibo {
	
	// ATRIBUTOS
	private String nroRecibo;
	private CitaTecnica citaTecnica;
	private Set<Pieza> piezas;
	private double importe;
	private String descripcion;
	private String observaciones;
	
	// CONSTRUCTORES
	public Recibo() { }

	public Recibo(String nroRecibo, CitaTecnica citaTecnica, Set<Pieza> piezas, double importe, String descripcion,
			String observaciones) {
		this.nroRecibo = nroRecibo;
		this.citaTecnica = citaTecnica;
		this.piezas = piezas;
		this.importe = importe;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
	}

	// MÉTODOS GETTER & SETTER
	public String getNroRecibo() {		return nroRecibo;	}
	public void setNroRecibo(String nroRecibo) {		this.nroRecibo = nroRecibo;	}

	public CitaTecnica getCitaTecnica() {		return citaTecnica;	}
	public void setCitaTecnica(CitaTecnica citaTecnica) {		this.citaTecnica = citaTecnica;	}

	public Set<Pieza> getPiezas() {		return piezas;	}
	public void setPiezas(Set<Pieza> piezas) {		this.piezas = piezas;	}

	public double getImporte() {		return importe;	}
	public void setImporte(double importe) {		this.importe = importe;	}

	public String getDescripcion() {		return descripcion;	}
	public void setDescripcion(String descripcion) {		this.descripcion = descripcion;	}

	public String getObservaciones() {		return observaciones;	}
	public void setObservaciones(String observaciones) {		this.observaciones = observaciones;	}

}
