package utp.taller.entidades;

public abstract class Persona {

		// ATRIBUTOS
		private String idPersona;
		private String nombrePrin, nombreSec, apePrin, apeSec;
		private int tipo_doc;
		private String nro_doc;
		private String telefono;
		private String distrito;
		private String direccion;
		private String email;
		private String contrasena;
		private boolean estado;

		// CONSTRUCTORES
		public Persona(){}

		public Persona(String id_persona, String nombrePrin,String nombreSec, String apePrin, String apeSec, String nro_doc, String telefono, String distrito, String direccion, boolean estado, String email,
				String contrasena) {
			this.idPersona = id_persona;
			this.nombrePrin = nombrePrin;
			this.nombreSec = nombreSec;
			this.apePrin = apePrin;
			this.apeSec = apeSec;
			this.nro_doc = nro_doc;
			this.telefono = telefono;
			this.distrito = distrito;
			this.direccion = direccion;
			this.email = email;
			this.contrasena = contrasena;
			this.estado = estado;
		}

		// MÉTODOS GETTER & SETTER
		public String getIdPersona() {			return idPersona;		}
		public void setIdPersona(String idPersona) {			this.idPersona = idPersona;		}
		
		public String getNombrePrin() {		return nombrePrin;	}
		public void setNombrePrin(String nombrePrin) {		this.nombrePrin = nombrePrin;	}
		
		public String getNombreSec() {	return nombreSec;	}
		public void setNombreSec(String nombreSec) {this.nombreSec = nombreSec;	}

		public String getApePrin() {		return apePrin;	}
		public void setApePrin(String apePrin) {		this.apePrin = apePrin;	}

		public String getApeSec() {		return apeSec;	}
		public void setApeSec(String apeSec) {		this.apeSec = apeSec;	}

		public int getTipo_doc() {		return tipo_doc;		}
		public void setTipo_doc(int tipo_doc) {			this.tipo_doc = tipo_doc;		}

		public String getNro_doc() {		return nro_doc;	}
		public void setNro_doc(String nro_doc) {		this.nro_doc = nro_doc;	}
		
		public String getTelefono() {			return telefono;		}
		public void setTelefono(String telefono) {			this.telefono = telefono;		}

		public String getDistrito() {	return distrito;	}
		public void setDistrito(String distrito) {	this.distrito = distrito;		}

		public String getDireccion() {		return direccion;	}
		public void setDireccion(String direccion) {		this.direccion = direccion;	}
		
		public boolean getEstado() {		return estado;		}
		public void setEstado(boolean estado) {		this.estado = estado;	}
		
		public String getEmail() {		return email;	}
		public void setEmail(String email) {		this.email = email;	}

		public String getContrasena() {		return contrasena;	}
		public void setContrasena(String contrasena) {		this.contrasena = contrasena;	}

		
		
}
