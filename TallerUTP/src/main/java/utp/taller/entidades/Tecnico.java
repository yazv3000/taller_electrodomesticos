package utp.taller.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tecnico extends Persona{

		// ATRIBUTOS
		private Set<Especialidad> especialidades;
		private List<Horario> horariosDisponibles;
		private int anios_experiencia;
		
		// CONSTRUCTORES
		public Tecnico() {}
		
		public Tecnico(String idTecnico, String nombre, String apePrin, String apeSec, String nro_doc, int anios_experiencia, String telefono, String direccion, String email,
				String contrasena) {
			super(idTecnico, nombre, apePrin, apeSec, nro_doc, telefono, direccion, email, contrasena);
			especialidades = new HashSet<Especialidad>();
			this.anios_experiencia = anios_experiencia;
			horariosDisponibles = new ArrayList<Horario>();
		}
		
		
		// MÉTODOS GETTER & SETTER
		public String getIdTecnico() {			return this.getIdPersona();		}
		public void setIdTecnico(String idTecnico) {			this.setIdPersona(idTecnico);		}

		public int getAnios_experiencia() {			return anios_experiencia;		}
		public void setAnios_experiencia(int anios_experiencia) {			this.anios_experiencia = anios_experiencia;		}
		
		// falta setter horariosDisponibles
		public List<Horario> getHorariosDisponibles() {			return horariosDisponibles;		}

		
}
