
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
		// Cargamos los datos en un array que se llama igual que la función
		String[] datosUsuario = datosUsuario(teclado);
		// Creamos la sentencia condicional 
		if (usuarios.containsKey(datosUsuario[1])) {
			System.out.println("El usuario ya existe.");
		} else {
			creacionObjetoUsuario(datosUsuario);
		}
	}

	/**
	 * Solicita los datos necesarios para crear un usuario
	 *
	 * @param teclado objeto para recoger datos del usuario
	 * 
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
		// Devolvemos los datos a un nuevo array
		return new String[]{nombre, email, password};
	}

	/**
	* Crea el objeto Usuario y lo añade a la colección
	*
	* <p> Los datos se cargan a través de las posiciones del array recibido <p>
	*
	* @param datos array con [nombre, email, password]
	*/
	private static void creacionObjetoUsuario(String[] datosUsuario) {
		// Creamos el objeto dentro de la colección usuarios e introducimos sus datos a través de las posiciones que ocupan en el array pasado por parámetro
		usuarios.put(datosUsuario[1], new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2]));
		System.out.println("Usuario creado correctamente.");
	}
	

	// ============= OPCIÓN 2 — ELIMINAR USUARIO =============
	
	/**
	 * Elimina un usuario de la colección usuarios
	 * 
	 * <p> Solicita el email del usuario a eliminar y lo borra si existe <p>
	 * 
	 * @param teclado objeto para recoger datos del usuario
	 */
	public static void eliminarUsuario(Scanner teclado) {
		// Cargamos el identificador correo
		String correoUsuario=identificadorUsuario(teclado);
		// Creamos la sentencia condicional
		if (usuarios.containsKey(correoUsuario)) {
			eliminacionObjetoUsuario(correoUsuario);
		}else {
			System.out.println("El usuario no existe.");
		}
		
	}
	
	/**
	 * Solicita el identificador del objeto Usuario creado
	 * 
	 * @param teclado objeto para recoger el identificador del usuario
	 * 
	 * @return correo identificador del usuario
	 */
	private static String identificadorUsuario(Scanner teclado) {
		// Solicitamos identificador y lo guardamos en una variable
		// Este método podría ser prescindible, pero así seguimos la misma estructura que para aniadirUsuario
		String correo;
		System.out.println("Introduce el correo del usuario que desea eliminar: ");
		return correo=teclado.nextLine();
	}
	
	/**
	 * Elimina el objeto usuario de la colección usuarios
	 * 
	 * @param correoUsuario identicador usuario
	 */
	private static void eliminacionObjetoUsuario(String correoUsuario) {
		// Eliminamos usuario de la colección a través del identifcador
		usuarios.remove(correoUsuario);
		System.out.println("Usuario eliminado correctamente.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
