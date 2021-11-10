package pe.edu.daniel.training.java.jd0.dao2;

import java.sql.SQLException;
import java.util.List;

public interface GenericoDAO<T> {
	List<T> listar() throws SQLException;
	List<T> listar(T t) throws SQLException;
	
	boolean insertar(T t) throws SQLException;
	
	boolean actualizar(T t) throws SQLException;
	
	boolean eliminar(T t) throws SQLException;
}
