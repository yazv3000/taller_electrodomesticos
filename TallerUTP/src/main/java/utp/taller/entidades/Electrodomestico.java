package utp.taller.entidades;

public class Electrodomestico {

	// ATRIBUTOS
	private int idElectrod;
	private String nroSerie;
	private int idtipoElectrod;
	private int idmarca;
	private String modelo;
	private int idpropietario;
	private boolean estadoActivo;
	
	
	// CONSTRUCTORES
	public Electrodomestico() { }
	
	public Electrodomestico(int idElectrod, String nroSerie, int idtipoElectrod, int idmarca, String modelo, int idpropietario, boolean estadoActivo) {
		this.idElectrod = idElectrod;
		this.nroSerie = nroSerie;
		this.idtipoElectrod = idtipoElectrod;
		this.idmarca = idmarca;
		this.modelo = modelo;
		this.idpropietario = idpropietario;
		this.estadoActivo = estadoActivo;
	}

	// MÉTODOS GETTER & SETTER
	public int getIdElectrod() {		return idElectrod;	}
	public void setIdElectrod(int idElectrod) {		this.idElectrod = idElectrod;	}
	
	public String getNroSerie() {		return nroSerie;	}
	public void setNroSerie(String nroSerie) {		this.nroSerie = nroSerie;	}

	public int getIdtipoElectrod() {return idtipoElectrod;}
	public void setIdtipoElectrod(int idtipoElectrod) {	this.idtipoElectrod = idtipoElectrod;	}

	public int getIdmarca() {return idmarca;}
	public void setIdmarca(int idmarca) {	this.idmarca = idmarca;	}

	public String getModelo() {		return modelo;	}
	public void setModelo(String modelo) {		this.modelo = modelo;	}

	public int getIdpropietario() {	return idpropietario;}
	public void setIdpropietario(int idpropietario) {	this.idpropietario = idpropietario;}

	public boolean isEstadoActivo() {	return estadoActivo;}
	public void setEstadoActivo(boolean estadoActivo) {	this.estadoActivo = estadoActivo;	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=== DATOS DEL ELECTRODOMÉSTICO ===");
		sb.append("\nID: ").append(idElectrod);
		sb.append("\nNro de serie: ").append(nroSerie);
		sb.append("\nID Tipo ").append(idtipoElectrod);
		sb.append("\nID Marca ").append(idmarca);
		sb.append("\nModelo ").append(modelo);
		sb.append("\nID propietario ").append(idpropietario);
		return sb.toString();
	}
	
}
