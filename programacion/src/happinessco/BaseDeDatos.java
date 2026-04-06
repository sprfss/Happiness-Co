package happinessco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
		// Cargamos los datos en un array que se llama igual que el método
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
		// Limpio el buffer
		teclado.nextLine();
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
		// Limpio el buffer
		teclado.nextLine();
		// Solicitamos identificador y lo guardamos en una variable
		// Este método podría ser prescindible, pero así seguimos la misma estructura que para aniadirUsuario
		System.out.println("Introduce el correo del usuario que desea eliminar: ");
		return teclado.nextLine();
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
	
	// ============= OPCIÓN 3 — AÑADIR EVENTO =============
	
	/**
	 * Añade un evento a la colección eventos
	 * 
	 * <p> Solicita los datos al usuario, genera el id automáticamente
	 * e inicializa la colección de galerías vacía <p>
	 * 
	 * @param teclado objeto para coger datos del usuario
	 */
	public static void aniadirEvento(Scanner teclado) {
		// Cargamos los datos en un array que se llama igual que el método
		String datosEvento[] = datosEvento(teclado);
		// Llamamos a crear objeto evento
		creacionObjetoEvento(datosEvento);
	}
	
	/**
	 * Solicita los datos necesarios para crear un evento
	 * 
	 * @param teclado objeto para coger datos del usuario
	 * @return array con [fehca, titulo, ubicacion, descripcion]
	 */
	private static String [] datosEvento(Scanner teclado) {
		// Limpio el buffer
		teclado.nextLine();
		String fecha, titulo, ubicacion, descripcion;
		System.out.println("Introduce la fecha del evento (dd-mm-yyyy): ");
		fecha = teclado.nextLine();
		System.out.println("Introduce el título del evento: ");
		titulo = teclado.nextLine();
		System.out.println("Introduce la ubicación del evento: ");
		ubicacion = teclado.nextLine();
		System.out.println("Introduce la descripción del evento: ");
		descripcion = teclado.nextLine();
		return new String[] {fecha, titulo, ubicacion, descripcion};
	}
	
	/**
	 * Crea el objeto Evento y lo añade a la colección
	 * 
	 * <p> El id se genera automáticamente con el contador
	 * y la colección de galerías se inicializa vacía <p>
	 * 
	 * @param datosEvento array con [fecha, titulo, ubicacion, descripcion]
	 */
	private static void creacionObjetoEvento(String [] datosEvento) {
		// El contador representa al id de la clase Evento
		// Creamos el objeto dentro de la colección eventos e introducimos sus datos a través de las posiciones que ocupan en el array pasado por parámetro
		eventos.put(contadorEventos, new Evento(contadorEventos, datosEvento[0], datosEvento[1], datosEvento[2], datosEvento[3]));
		contadorEventos++;
		System.out.println("Evento creado correctamente.");
	}
	
	// ============= OPCIÓN 4 — ELIMINAR EVENTO =============
	/**
	 * Elimina un evento de la colección eventos
	 * 
	 * <p> Muestra el listado de eventos y elimina el seleccionado a través del id <p>
	 * 
	 * @param teclado objeto para coger datos del usuario
	 */
	public static void eliminarEvento(Scanner teclado) {
		// LLamamos a mostrar evento
		mostrarEventos();
		// Cargamos el identificador a eliminar
		int idEvento= identificadorEvento(teclado);
		// Creamos la setencia condicional
		if (eventos.containsKey(idEvento)) {
			eliminarObjetoEvento(idEvento);
		}else {
			System.out.println("El evento no existe.");
		}
		
	}
	/**
	 * Muestra por pantalla el contenido de la colección eventos
	 * 
	 */
	private static void mostrarEventos() {
		// Para recorrer colecciones usamos el bucle for-each
		System.out.println("----------- LISTADO DE EVENTOS -----------");
		// Recorro la colección de eventos para mostrar todos los registrados
		for (Evento evento : eventos.values()) {
		    // Muestro todos los atributos del evento en cada iteración
		    System.out.println(String.format(
		        "ID: %d | Fecha: %s | Título: %s | Ubicación: %s | Descripción: %s",
		        evento.getId(),
		        evento.getFecha(),
		        evento.getTitulo(),
		        evento.getUbicacion(),
		        evento.getDescripcion()
		    ));
		}
		
	}
	/**
	 * Solicita el id del evento que se desea eliminar
	 * 
	 * @param teclado objeto para coger datos del usuario
	 * @return idEvento identificador del evento
	 */
	private static int identificadorEvento(Scanner teclado) {
		// Limpio buffer
		teclado.nextLine();
		System.out.println("Introduce el id del evento que desea eliminar: ");
		return teclado.nextInt();
	}
	/**
	 * Elimina el obejto evento de la colección eventos
	 * 
	 * @param idEvento identificador del evento
	 */
	private static void eliminarObjetoEvento(int idEvento) {
		// Eliminamos evento de la colección a través del identifcador
		eventos.remove(idEvento);
		System.out.println("Evento eliminado correctamente.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
