package utp.taller.entidades;

public abstract class Persona {

		// ATRIBUTOS
		private String idUsuario;
		private int idPersona;
		private String nombrePrin, nombreSec, apePrin, apeSec;
		private int tipoDocumento;
		private String nro_doc;
		private String telefono;
		private int idDistrito;
		private String direccion;
		private String email, contrasena;
		private String rutaFoto;
		private boolean estadoActivo;

		// CONSTRUCTORES
		public Persona(){}

		// MÉTODOS GETTER & SETTER
		public String getIdUsuario()	
			{return idUsuario;	}
		public void setIdUsuario(String idUsuario) 		
			{this.idUsuario = idUsuario;	}
		
		public int getIdPersona() 		
			{return idPersona;}
		public void setIdPersona(int idPersona) 			
			{this.idPersona = idPersona;	}
		
		// Datos personales
		public String getNombrePrin() 
			{return nombrePrin;}
		public void setNombrePrin(String nombrePrin) 
			{this.nombrePrin = nombrePrin;}
		
		public String getNombreSec() 	
			{return nombreSec;}
		public void setNombreSec(String nombreSec) 
			{this.nombreSec = nombreSec;}
		
		public String getApePrin() 		
			{return apePrin;}	
		public void setApePrin(String apePrin) 			
			{this.apePrin = apePrin;}
		
		public String getApeSec() 		
			{return apeSec;}
		public void setApeSec(String apeSec) 				
			{this.apeSec = apeSec;}

		public int getTipoDocumento() 
			{	return tipoDocumento;	}
		public void setTipoDocumento(int tipo_doc) 
			{this.tipoDocumento = tipo_doc;}

		public String getNroDocumento() 		
			{return nro_doc;}
		public void setNroDocumento(String nro_doc)			
			{this.nro_doc = nro_doc;}
		
		public String getRutaFoto() 
			{return rutaFoto;}
		public void setRutaFoto(String rutaFoto)
			{this.rutaFoto = rutaFoto;}

		public String getTelefono() 		
			{return telefono;}
		public void setTelefono(String telefono)			
			{this.telefono = telefono;}

		public int getIdDistrito()			 
			{	return idDistrito;	}
		public void setIdDistrito(int idDistrito) 			
			{this.idDistrito = idDistrito;	}
		
		public String getDireccion() 		
			{return direccion;}
		public void setDireccion(String direccion) 		
			{this.direccion = direccion;}
		
		// Datos del Usuario
		public String getEmail() 			
			{return email;}
		public void setEmail(String email) 					
			{this.email = email;	}

		public String getContrasena() 	
			{return contrasena;	}
		public void setContrasena(String contrasena) 
			{this.contrasena = contrasena;}

		// Estado
		public boolean isEstadoActivo() 
			{return estadoActivo;	}
		public void setEstadoActivo(boolean estadoActivo) 
			{this.estadoActivo = estadoActivo;}

}
