package utp.taller.dto;

public class DtoTecnicoConsulta extends DtoPersonaConsulta{
	
	private String especialidad; 
	
	// MÉTODOS GETTER & SETTER
	
	public String getEspecialidad() {	return especialidad;}
	public void setEspecialidad(String especialidad) {	this.especialidad = especialidad;}
	
	public String getIdTecnico() {			return this.getIdUsuario();		}
	public void setIdTecnico(String idTecnico) {			this.setIdUsuario(idTecnico);		}

}
