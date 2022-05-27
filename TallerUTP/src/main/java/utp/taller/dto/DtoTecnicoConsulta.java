package utp.taller.dto;

public class DtoTecnicoConsulta extends DtoPersonaConsulta{
	
	private String especialidad; 
	
	// MÉTODOS GETTER & SETTER
	
	public String getEspecialidad() {	return especialidad;}
	public void setEspecialidad(String especialidad) {	this.especialidad = especialidad;}

	public int getIdPersonaTecnico() {	return this.getIdPersona();	}
	public void setIdPersonaTecnico(int idPersona) {		this.setIdPersona(idPersona);	}
		
	public String getIdUsuarioTecnico() {			return this.getIdUsuario();		}
	public void setIdUsuarioTecnico(String idTecnico) {			this.setIdUsuario(idTecnico);		}

}
