package utp.taller.entidades;

public class Pieza {
	
		// ATRIBUTOS
		private int idPieza;
		private String nomPieza;
		private long stock;
		private double precio;
		private String categoria;
	
		// CONSTRUCTORES
		public Pieza() { }

		public Pieza(int idPieza, String nomPieza, long stock, double precio, String categoria) {
			this.idPieza = idPieza;
			this.nomPieza = nomPieza;
			this.stock = stock;
			this.precio = precio;
			this.categoria = categoria;
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

		public String getCategoria() {			return categoria;		}
		public void setCategoria(String categoria) {			this.categoria = categoria;		}

}
