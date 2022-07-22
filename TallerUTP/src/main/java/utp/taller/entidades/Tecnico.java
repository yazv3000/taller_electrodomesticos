package utp.taller.entidades;

public class Tecnico extends Persona{

	// ATRIBUTOS
	private int[] idsEspecialidad;
	private int anios_experiencia;
	
	// CONSTRUCTORES
	public Tecnico() {}

	// MÉTODOS GETTER & SETTER
	public int getIdPersonaTecnico() {	return this.getIdPersona();	}
	public void setIdPersonaTecnico(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioTecnico() {		return this.getIdUsuario(); }
	public void setIdUsuarioTecnico(String idUsuario) {		this.setIdUsuario(idUsuario);	}

	public int getAniosExperiencia() {			return anios_experiencia;		}
	public void setAniosExperiencia(int anios_experiencia) {			this.anios_experiencia = anios_experiencia;		}
	
	public int[] getIdsEspecialidad() {			return idsEspecialidad;		}
	public void setIdsEspecialidad(int[] idsEspecialidad) {			this.idsEspecialidad = idsEspecialidad;		}
}