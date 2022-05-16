package utp.taller.dao;

import java.util.List;

public interface BaseDAO<T> {
	
	public List<T> listar();
	
	public int insertar(T obj_nuevo);
	
	public int modificar(T obj_modificar);
	
	public int eliminar(int id);
 
}
