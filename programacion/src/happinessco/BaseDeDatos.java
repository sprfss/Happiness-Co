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
	
	// ============= OPCIONES DEL MENÚ ===================== //
	
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
	* Crea el objeto Usuario y lo añade a la colección usuarios
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
		String correoUsuario=identificadorTexto(teclado, "Introduce el correo del usuario que desea eliminar: ");
		// Creamos la sentencia condicional
		if (usuarios.containsKey(correoUsuario)) {
			eliminacionObjetoUsuario(correoUsuario);
		}else {
			System.out.println("El usuario no existe.");
		}
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
	 * Crea el objeto Evento y lo añade a la colección eventos
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
		int idEvento= identificadorNumerico(teclado, "Introduce el id del evento que desea eliminar: ");
		// Creamos la setencia condicional
		if (eventos.containsKey(idEvento)) {
			eliminarObjetoEvento(idEvento);
		}else {
			System.out.println("El evento no existe.");
		}
		
	}
	
	/**
	 * Elimina el objeto evento de la colección eventos
	 * 
	 * @param idEvento identificador del evento
	 */
	private static void eliminarObjetoEvento(int idEvento) {
		// Eliminamos evento de la colección a través del identifcador
		eventos.remove(idEvento);
		System.out.println("Evento eliminado correctamente.");
	}
	
	// ============= OPCIÓN 5 — AÑADIR GALERÍA =============
	
	/**
	 * Añade una galería al evento seleccionado
	 * 
	 * <p> Muestra el listado de eventos, solicita el id del evento y
	 *  añade la galería a su colección interna <p>
	 *  
	 * @param teclado objeto para coger datos del usuario
	 */
	public static void aniadirGaleria(Scanner teclado) {
		// Mostramos el listado de eventos
		mostrarEventos();
		// Cargamos el identificador del evento
		int idEventoGaleria = identificadorNumerico(teclado, "¿De qué evento deseas crear una galería? Introduce su identifcador: ");
		// Comprobamos que el evento existe
		if (eventos.containsKey(idEventoGaleria)) {
			// Cargamos los datos de la galería
			String titulo = datosGaleria(teclado);
			// Creamos el objeto galería
			creacionObjetoGaleria(idEventoGaleria, titulo);
		} else {
			System.out.println("El evento no existe.");
		}	
	}
	
	/**
	 *  Solicita los datos necesarios para crear una galería
	 *  
	 * @param teclado objeto para coger datos del usuario
	 * @return titulo  título de la galería
	 */
	private static String datosGaleria(Scanner teclado) {
		// Limpio buffer
		teclado.nextLine();
		System.out.println("Introduce el título de la galería: ");
		return teclado.nextLine();
	}
	
	/**
	 * Crea el objeto Galeria y lo añade a la colección de galerías del evento
	 * 
	 * @param idEventoGaleria identificador del evento
	 * @param titulo título de la galería
	 */
	private static void creacionObjetoGaleria (int idEventoGaleria, String titulo) {
		eventos.get(idEventoGaleria).getGalerias().add(new Galeria(contadorGalerias, titulo, idEventoGaleria));
		contadorGalerias++;
		System.out.println("Galería creada correctamente.");
	}
	
	// ============= OPCIÓN 6 — ELIMINAR GALERÍA =============
	
	/**
	 * Elimina la galería de una evento
	 * 
	 * <p> Muestra los eventos, escoge uno, muestra las galerías del evento escogido
	 * escoge una y la elimina <p>
	 * 
	 * @param teclado objeto para coger datos del usuario
	 */
	public static void eliminarGaleria(Scanner teclado) {
		// Muestro el listado de los eventos (Reciclo método)
		mostrarEventos();
	    // Cargamos el identificador del evento
		int idEventoGaleria = identificadorNumerico(teclado, "Introduce el identificador del evento al que le deseas eliminar una galería: ");
		// Comprobamos que el evento existe
		if (eventos.containsKey(idEventoGaleria)) {
			// Mostramos el listado de galerías del evento
			mostrarGalerias(idEventoGaleria);
			// Cargamos el identificador de la galería
			int idGaleria = identificadorNumerico(teclado, "Introduce el identificador de la galería que desea eliminar: ");
			// Eliminamos la galería
			eliminacionObjetoGaleria(idEventoGaleria, idGaleria);
		}else {
			System.out.println("El evento no existe.");
		}
	}
	
	/**
	 * Muestra por pantalla el listado de galerías de un evento concreto
	 *
	 * @param idEventoGaleria identificador del evento
	 */
	private static void mostrarGalerias(int idEventoGaleria) {
		System.out.println("----------- LISTADO DE GALERÍAS -----------");
		// Recorro la colección de galerías del evento para mostrar todas las registradas
		for (Galeria galeria : eventos.get(idEventoGaleria).getGalerias()) {
			System.out.println(String.format(
				"ID: %d | Título: %s",
				galeria.getId(),
				galeria.getTitulo()
			));
		}
	}
	
	/**
	 * Elimina el objeto galería de la colección de galerías del evento
	 * 
	 * @param idEventoGaleria identificador del evento
	 * @param idGaleria identificador de la galería
	 */
	private static void eliminacionObjetoGaleria(int idEventoGaleria, int idGaleria) {
		// Guardo la referencia a la colección de galerías del evento
	    ArrayList<Galeria> galerias = eventos.get(idEventoGaleria).getGalerias();
	    // Recorro la colección para encontrar la galería que coincide con el idGaleria
	    for (Galeria galeria : galerias) {
	        if (galeria.getId() == idGaleria) {
	            galerias.remove(galeria);
	            System.out.println("Galería eliminada correctamente.");
	            return;
	        }
	    }
	    System.out.println("La galería no existe.");

	}
	
	// ============= OPCIÓN 7 — AÑADIR FAVORITO =============
	
	/**
	 * Crea un evento favorito asociado a un usuario
	 * 
	 * <p> Muestra los eventos y usuarios de las colecciones, solicita los identifcadores,
	 * chequea la existencia de ambos y crea un objeto y lo añade a la colección de favoritos <p>
	 * 
	 * @param teclado objeto para coger datos del usuario
	 */
	public static void aniadirFavorito(Scanner teclado) {
		// Muestro eventos y usuarios
		mostrarEventos();
		mostrarUsuarios();
		// Cargamos el identificador del evento y el correo del usuario
		int idEventoFavorito=identificadorNumerico(teclado, "Introduce el identificador de tu evento favorito: ");
		String correoUsuario=identificadorTexto(teclado, "Introduce un correo de usuario para crear el evento favorito: ");
		// Comprobamos que los datos existan
		if (eventos.containsKey(idEventoFavorito) && usuarios.containsKey(correoUsuario)) {
			// Creamos el objeto favorito
			creacionObjetoFavorito(idEventoFavorito, correoUsuario);
		}else{
			System.out.println("El evento o/y correo de usuario introducido no existe o existen");
		}
	}
	
   /**
    * Muestra por pantalla el contenido de la colección usuarios
    * 
    */
   private static void mostrarUsuarios() {
	// Para recorrer colecciones usamos el bucle for-each
	   System.out.println("-------------- LISTADO DE USUARIOS ----------");
	// Recorro la colección de usuarios para mostrar todos los registrados
	   for (Usuario usuario : usuarios.values()){
		   // Muestro todos los atributos del usuario en cada iteración
		   System.out.println(String.format(
				   "Nombre: %s | Email: %s",
				   usuario.getNombre(),
				   usuario.getEmail()
				   // usuario.getPassword() No es buena práxis mostrar la contraseña de los usuarios
				   ));
	   }
   }
   
   /**
    * Crea el objeto Favorito y lo añade a la colección favoritos
    * 
    * @param idEventoFavorito identificador del evento
    * @param correoUsuario	  identificador del usuario
    */
   private static void creacionObjetoFavorito(int idEventoFavorito, String correoUsuario){
	   favoritos.add(new Favorito(correoUsuario, idEventoFavorito));
	   System.out.println("Favorito creado correctamente.");
	   
   }
	
	
	
	
	
	
	
	
	
	// ============ MÉTODOS RECICLADOS ===============
	
	/**
	 * Solicita un identificador numérico
	 *
	 * <p> Método reutilizable para todas las opciones que requieren
	 * identificar un objeto por su id numérico <p>
	 *
	 * @param teclado objeto para coger datos del usuario
	 * @param mensaje mensaje a mostrar al usuario
	 * @return identificador numérico introducido
	 */
	private static int identificadorNumerico(Scanner teclado, String mensaje) {
	    // Limpio buffer
	    teclado.nextLine();
	    System.out.println(mensaje);
	    return teclado.nextInt();
	}

	/**
	 * Solicita un identificador de texto
	 *
	 * <p> Método reutilizable para todas las opciones que requieren
	 * identificar un objeto por un texto como el correo <p>
	 *
	 * @param teclado objeto para coger datos del usuario
	 * @param mensaje mensaje a mostrar al usuario
	 * @return identificador de texto introducido
	 */
	private static String identificadorTexto(Scanner teclado, String mensaje) {
	    // Limpio buffer
	    teclado.nextLine();
	    System.out.println(mensaje);
	    return teclado.nextLine();
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
	
}
