
package happinessco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 /**
 * Clase intermediaria entre Main y las clases del modelo de datos
 *
 * <p> Gestiona las colecciones de usuarios, eventos y favoritos,
 * y contiene toda la lógica de las opciones del menú, manteniendo
 * el bajo acoplamiento del sistema <p>
 * 
 */
public class BaseDeDatos {
	
	// ============= COLECCIONES  =============
	
	/** Colección que almacena los usuarios introducidos. Clave: email único*/
	private static HashMap<String, Usuario> usuarios=new HashMap<>();
	/** Colección que almacena los eventos introducidos. Clave: id autogenerado*/
	private static HashMap<Integer, Evento> eventos=new HashMap<>();
	/** Almacena los eventos favoritos de los usuarios*/
	private static ArrayList<Favorito> favoritos=new ArrayList<>();
	
	// ============= CONTADORES =============

	/** Contador autogenerado para los ids de eventos */
	private static int contadorEventos = 0;
	/** Contador autogenerado para los ids de galerías */
	private static int contadorGalerias = 0;
	
	
	// ============= OPCIÓN 1 — AÑADIR USUARIO =============

	/**
	 * Añade un usuario a la colección usuarios
	 *
	 * <p> Solicita los datos al usuario, comprueba que el email no exista
	 * y crea el objeto si es único <p>
	 *
	 * @param teclado objeto para coger datos del usuario
	 */
	public static void aniadirUsuario(Scanner teclado) {
		String[] datos = datosUsuario(teclado);
		if (usuarios.containsKey(datos[1])) {
			System.out.println("El usuario ya existe");
		} else {
			creacionObjetoUsuario(datos);
		}
	}

	/**
	 * Solicita los datos necesarios para crear un usuario
	 *
	 * @param teclado objeto para coger datos del usuario
	 * @return array con [nombre, email, password]
	 */
	private static String[] datosUsuario(Scanner teclado) {
		String nombre, email, password;
		System.out.println("Introduce el nombre del usuario: ");
		nombre = teclado.nextLine();
		System.out.println("Introduce el email del usuario: ");
		email = teclado.nextLine();
		System.out.println("Introduce la contraseña del usuario: ");
		password = teclado.nextLine();
		return new String[]{nombre, email, password};
	}

	/**
	* Crea el objeto Usuario y lo añade a la colección
	*
	* <p> Los datos se cargan a través de las posiciones del array recibido <p>
	*
	* @param datos array con [nombre, email, password]
	*/
	private static void creacionObjetoUsuario(String[] datos) {
		usuarios.put(datos[1], new Usuario(datos[0], datos[1], datos[2]));
		System.out.println("Usuario creado correctamente");
	}
	

	
	
	
	
	
	
}
