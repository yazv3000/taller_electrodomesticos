package utp.taller.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tecnico extends Usuario{

		// ATRIBUTOS
		private int idTecnico;
		private String nombre, apePrin, apeSec;
		private String nro_doc;
		private String direccion;
		private Set<Especialidad> especialidades;
		private List<Horario> horariosDisponibles;
		private int anios_experiencia;
		
		// CONSTRUCTORES
		public Tecnico() {}
		
		public Tecnico(int idTecnico, String nombre, String apePrin, String apeSec, String nro_doc, String direccion, int anios_experiencia, String email, String contrasena) {
			super(email, contrasena);
			this.idTecnico = idTecnico;
			this.nombre = nombre;
			this.apePrin = apePrin;
			this.apeSec = apeSec;
			this.nro_doc = nro_doc;
			this.direccion = direccion;
			especialidades = new HashSet<Especialidad>();
			this.anios_experiencia = anios_experiencia;
			horariosDisponibles = new ArrayList<Horario>();
		}
		
		// MÉTODOS GETTER & SETTER
		public int getIdTecnico() {			return idTecnico;		}
		public void setIdTecnico(int idTecnico) {			this.idTecnico = idTecnico;		}

		public String getNombre() {		return nombre;	}
		public void setNombre(String nombre) {		this.nombre = nombre;	}
		
		public String getApePrin() {		return apePrin;	}
		public void setApePrin(String apePrin) {		this.apePrin = apePrin;	}

		public String getApeSec() {		return apeSec;	}
		public void setApeSec(String apeSec) {		this.apeSec = apeSec;	}

		public String getNro_doc() {		return nro_doc;	}
		public void setNro_doc(String nro_doc) {		this.nro_doc = nro_doc;	}
		
		// falta setter especialidades
		public Set<Especialidad> getEspecialidades() {			return especialidades;		}

		public String getDireccion() {		return direccion;	}
		public void setDireccion(String direccion) {		this.direccion = direccion;	}

		public int getAnios_experiencia() {			return anios_experiencia;		}
		public void setAnios_experiencia(int anios_experiencia) {			this.anios_experiencia = anios_experiencia;		}
		
		// falta setter horariosDisponibles
		public List<Horario> getHorariosDisponibles() {			return horariosDisponibles;		}

		
}
