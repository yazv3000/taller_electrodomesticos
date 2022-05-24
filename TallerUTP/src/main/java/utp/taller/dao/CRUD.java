package utp.taller.dao;

public interface CRUD<T> {
	
	public T consultarId(int id);
	
	public int insertar(T obj_nuevo);
	
	public int modificar(T obj_modificar);
	
	public int desactivar(int id);
 
}
