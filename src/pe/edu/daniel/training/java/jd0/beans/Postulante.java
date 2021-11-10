package pe.edu.daniel.training.java.jd0.beans;

public class Postulante {
	private String estadoPostulante;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String dni;
	private String fechaNacimientoM;
	private String telefono;
	private String correo;
	private String sexo;
	private String departamento;
	private String provincia;
	private String distrito;
	
	public Postulante() {
		
	}
	

	

	public String getEstadoPostulante() {
		return estadoPostulante;
	}


	public void setEstadoPostulante(String estadoPostulante) {
		this.estadoPostulante = estadoPostulante;
	}




	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getNombre() {
		return nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public String getFechaNacimientoM() {
		return fechaNacimientoM;
	}

	public String getCorreo() {
		return correo;
	}

	public String getSexo() {
		return sexo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setFechaNacimientoM(String fechaNacimientoM) {
		this.fechaNacimientoM = fechaNacimientoM;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	@Override
	public String toString() {
		return "Postulante [estadoPostulante=" + estadoPostulante + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", dni=" + dni + ", fechaNacimientoM="
				+ fechaNacimientoM + ", telefono=" + telefono + ", correo=" + correo + ", sexo=" + sexo
				+ ", departamento=" + departamento + ", provincia=" + provincia + ", distrito=" + distrito + "]";
	}




	
}
