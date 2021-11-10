package pe.edu.daniel.training.java.jd0.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.daniel.training.java.jd0.beans.Postulante;
import pe.edu.daniel.training.java.jd0.dao2.PostulanteDAO;
import util.BD;

public class PostulanteDaolmpl implements PostulanteDAO {
	// MOSTRAR DATOS CON EL ESTADO DISPONIBLE O NO DISPONIBLE

	public List<Postulante> listar() {
		try {
			Connection cn = BD.getConnection();
			String sql = "SELECT NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,DNI,FECHA_NACIMIENTO,TELEFONO,CORREO,SEXO,DEPARTAMENTO,PROVINCIA,DISTRITO,ESTADO_POSTULANTE FROM POSTULANTE  WHERE ESTADO_POSTULANTE = 'DISPONIBLE'";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Postulante> postulantes = new ArrayList<Postulante>();
			while (rs.next()) {
				Postulante postulante = new Postulante();
				postulante.setNombre(rs.getString("NOMBRE"));
				postulante.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
				postulante.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
				postulante.setDni(rs.getString("DNI"));
				postulante.setFechaNacimientoM(rs.getString("FECHA_NACIMIENTO"));
				postulante.setTelefono(rs.getString("TELEFONO"));
				postulante.setCorreo(rs.getString("CORREO"));
				postulante.setSexo(rs.getString("SEXO"));
				postulante.setDepartamento(rs.getString("DEPARTAMENTO"));
				postulante.setProvincia(rs.getString("PROVINCIA"));
				postulante.setDistrito(rs.getString("DISTRITO"));
				postulante.setEstadoPostulante(rs.getString("ESTADO_POSTULANTE"));
				postulantes.add(postulante);
			}
			rs.close();
			cn.close();
			ps.close();
			return postulantes;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Postulante> listar(Postulante postulante) throws SQLException {

		return null;
	}

	// INSERTAR DATOS
	public boolean insertar(Postulante postulante) {
		try {
			Connection cn = BD.getConnection();
			String sql = "INSERT INTO POSTULANTE(NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO, DNI,FECHA_NACIMIENTO,TELEFONO,CORREO,SEXO,DEPARTAMENTO,PROVINCIA,DISTRITO) VALUES \r\n"
					+ "(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, postulante.getNombre());
			ps.setString(2, postulante.getApellidoPaterno());
			ps.setString(3, postulante.getApellidoMaterno());
			ps.setString(4, postulante.getDni());
			ps.setString(5, postulante.getFechaNacimientoM());
			ps.setString(6, postulante.getTelefono());
			ps.setString(7, postulante.getCorreo());
			ps.setString(8, postulante.getSexo());
			ps.setString(9, postulante.getDepartamento());
			ps.setString(10, postulante.getProvincia());
			ps.setString(11, postulante.getDistrito());
			ps.executeUpdate();

			cn.close();
			ps.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ACTUALIZAR DATOS CON EL DNI
	public boolean actualizar(Postulante postulante) {
		try {
			Connection cn = BD.getConnection();
			String sql = "UPDATE POSTULANTE SET NOMBRE = ?, APELLIDO_PATERNO = ?, FECHA_NACIMIENTO = ? WHERE DNI = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, postulante.getNombre());
			ps.setString(2, postulante.getApellidoPaterno());
			ps.setString(3, postulante.getFechaNacimientoM());
			ps.setString(4, postulante.getDni());
			ps.executeUpdate();

			cn.close();
			ps.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ELIMINAR CON EL DNI
	public boolean eliminar(Postulante postulante) {
		try {
			Connection cn = BD.getConnection();
			String sql = "UPDATE POSTULANTE SET ESTADO_POSTULANTE = 'NO DISPONIBLE' WHHERE DNI = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, postulante.getDni());
			ps.executeQuery();
			cn.close();
			ps.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
