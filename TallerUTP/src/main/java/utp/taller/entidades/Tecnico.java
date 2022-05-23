package utp.taller.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tecnico extends Persona{

		// ATRIBUTOS
		private String especialidad;
		private List<Horario> horariosDisponibles;
		private int anios_experiencia;
		
		// CONSTRUCTORES
		public Tecnico() {}
		
		public Tecnico(String idTecnico, String nombrePrin, String nombreSec, String apePrin, String apeSec, String nro_doc, int anios_experiencia, String telefono, String distrito, String direccion, boolean estado, String email,
				String contrasena, String especialidad) {
			super(idTecnico, nombrePrin, nombreSec, apePrin, apeSec, nro_doc, telefono, distrito, direccion, estado, email, contrasena);
			this.especialidad = especialidad;
			this.anios_experiencia = anios_experiencia;
			horariosDisponibles = new ArrayList<Horario>();
		}
		
		
		// MÉTODOS GETTER & SETTER
		public String getIdTecnico() {			return this.getIdPersona();		}
		public void setIdTecnico(String idTecnico) {			this.setIdPersona(idTecnico);		}

		public int getAnios_experiencia() {			return anios_experiencia;		}
		public void setAnios_experiencia(int anios_experiencia) {			this.anios_experiencia = anios_experiencia;		}
		
		public String getEspecialidad() {return especialidad;	}
		public void setEspecialidad(String especialidad) {	this.especialidad = especialidad;	}

		// falta setter horariosDisponibles
		public List<Horario> getHorariosDisponibles() {			return horariosDisponibles;		}

		
}
