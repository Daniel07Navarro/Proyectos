package pe.edu.daniel.training.java.jd0.app;

import java.util.List;
import java.util.Scanner;

import pe.edu.daniel.training.java.jd0.beans.Postulante;
import pe.edu.daniel.training.java.jd0.dao.impl.PostulanteDaolmpl;
import pe.edu.daniel.training.java.jd0.dao2.PostulanteDAO;

public class AppPostulantes {
	public static void main(String[] args) {
		//insertarDatos();
		listar();
	}

	private static PostulanteDAO postulanteDAO = new PostulanteDaolmpl();

	private static Scanner trabajo = new Scanner(System.in);

	private static void listar() {
		try {
			List<Postulante> postulantes = postulanteDAO.listar();
			postulantes.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void validarDni(String dni) {
		while (dni.length() != 8) {
			System.out.print("Error su Dni debe tener 8 digitos, vuelva a digitarlo: ");
			dni = trabajo.nextLine();
		}
		
	}

	public static void pedirTelefono(String respuesta2, String telefono) {
		String telefonoFijo, telefonoCelular;
		if (respuesta2.equals("fijo")) {
			System.out.print("Ingrese su telefono fijo: ");
			telefonoFijo = trabajo.nextLine();
			telefono = telefonoFijo;
		} else if (respuesta2.equals("celular")) {
			System.out.print("Ingrese su telefono celular: ");
			telefonoCelular = trabajo.nextLine();
			telefono = telefonoCelular;
		}
	}

	private static void insertarDatos() {
		String nombre, apellidoPaterno, apellidoMaterno = null, dni, fechaNacimiento, correo, sexo,
				departamento, provincia, distrito;
		String respuesta, respuesta2;
		String telefono = null;
		// System.out.println();
		System.out.print("Ingrese su nombre: ");
		nombre = trabajo.nextLine();
		System.out.print("Ingrese su apellido paterno: ");
		apellidoPaterno = trabajo.nextLine();
		// trabajo.nextLine();
		do {
			System.out.print("¿Desea ingresar su apellido materno? Si-No: ");
			respuesta = trabajo.nextLine();
			if(respuesta.equals("Si")) {
				System.out.print("Ingrese su apellido materno: ");
				apellidoMaterno = trabajo.nextLine();
			}else {
				apellidoMaterno = "No puso";
			}
		} while ((!respuesta.equals("Si") && (!respuesta.equals("No"))));

		System.out.print("Ingrese su dni: ");
		dni = trabajo.nextLine();
		validarDni(dni);
		System.out.print("Digite su fecha de nacimiento: ");
		fechaNacimiento = trabajo.nextLine();
		do {
			System.out.print("¿Insetara telefono fijo o celular? fijo-celular: ");
			respuesta2 = trabajo.nextLine();
		} while ((!respuesta2.equals("fijo") && (!respuesta2.equals("celular"))));
		pedirTelefono(respuesta2, telefono);

		// FALTA VALIDAR EL CORREO
		System.out.print("Ingrese su correo: ");
		correo = trabajo.nextLine();

		do {
			System.out.print("Ingrese su sexo: M-F: ");
			sexo = trabajo.nextLine();
			if (sexo.charAt(0) != 'M' && sexo.charAt(0) != 'F') {
				System.out.println("Error el sexo debe ser M o F ");
			}
		} while (sexo.charAt(0) != 'M' && sexo.charAt(0) != 'F');

		System.out.print("Ingrese su departamento de residencia: ");
		departamento = trabajo.nextLine();
		System.out.print("Ingrese su provincia de residencia: ");
		provincia = trabajo.nextLine();
		System.out.print("Ingrese su su distrito: ");
		distrito = trabajo.nextLine();
		try {

			Postulante postulante = new Postulante();
			postulante.setNombre(nombre);
			postulante.setApellidoPaterno(apellidoPaterno);
			postulante.setApellidoMaterno(apellidoMaterno);
			postulante.setDni(dni);
			postulante.setFechaNacimientoM(fechaNacimiento);
			postulante.setTelefono(telefono);
			postulante.setCorreo(correo);
			postulante.setSexo(sexo);
			postulante.setDepartamento(departamento);
			postulante.setProvincia(provincia);
			postulante.setDistrito(distrito);

			if (postulanteDAO.insertar(postulante)) {
				System.out.println("EXITO AL INSERTAR");
			} else {
				System.out.println("ERROR AL INSERTAR");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
