package utp.taller.entidades;

public class Pieza {
	
		// ATRIBUTOS
		private int idPieza;
		private String nomPieza;
		private long stock;
		private double precio;
		private CategoriaPieza categoria;
		private boolean estadoActivo;
	
		// CONSTRUCTORES
		public Pieza() { }

		public Pieza(int idPieza, String nomPieza, long stock, double precio, CategoriaPieza categoria, boolean estado) {
			this.idPieza = idPieza;
			this.nomPieza = nomPieza;
			this.stock = stock;
			this.precio = precio;
			this.categoria = categoria;
			this.estadoActivo = estado;
		}

		// MÉTODOS GETTER & SETTER
		public int getIdPieza() {			return idPieza;		}
		public void setIdPieza(int idPieza) {			this.idPieza = idPieza;		}

		public String getNomPieza() {			return nomPieza;		}
		public void setNomPieza(String nomPieza) {			this.nomPieza = nomPieza;		}

		public long getStock() {			return stock;		}
		public void setStock(long stock) {			this.stock = stock;		}
		
		public double getPrecio() {			return precio;		}
		public void setPrecio(double precio) {			this.precio = precio;		}

		public CategoriaPieza getCategoria() {			return categoria;		}
		public void setCategoria(CategoriaPieza categoria) {			this.categoria = categoria;		}

		public boolean isEstadoActivo() {			return estadoActivo;		}
		public void setEstadoActivo(boolean estadoActivo) {			this.estadoActivo = estadoActivo;		}
		
}
