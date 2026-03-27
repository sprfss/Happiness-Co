/**
 * 
 * Paquete principal de la aplicación web Happiness & Co.
 *
 * <p>Contiene las clases del modelo de datos de la agenda cultural y la clase principal
 * para la gestión mediante un menú de consola.</p>
 *
 * <p>Clases incluidas:</p>
 * <ul>
 *   <li>{@link happinessco.Usuario} — gestión de usuarios registrados</li>
 *   <li>{@link happinessco.Evento} — gestión de eventos culturales</li>
 *   <li>{@link happinessco.Galeria} — gestión de galerías de imágenes</li>
 *   <li>{@link happinessco.Favorito} — gestión de eventos favoritos por usuario</li>
 *   <li>{@link happinessco.Main} — clase principal con el menú de gestión</li>
 * </ul>
 *
 * <p>Las colecciones se gestionan con {@link java.util.HashMap} y
 * {@link java.util.ArrayList}.</p>
 *
 * @author Sara Pérez Rodríguez
 * @version 1.0
 * 
 */
package happinessco;

// Importo paquetes utilizados
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Clase principal
 * 
 * <p> Contiene el método main  <p>
 */
public class Main {
	
	// ============= CONSTANTES =============
	
	/** Entero válido menor que forma parte de las opciones del menú */
	final static int PRIMERA_OPCION_MENU = 1;
	/** Entero válido mayor que forma parte de las opciones del menú */
	final static int ULTIMA_OPCION_MENU = 9;
	
	// ============= COLECCIONES  =============
	
	/** Colección que almacena los usuarios introducidos */
	static HashMap<String, Usuario> usuarios=new HashMap<>();
	/** Colección que almacena los eventos introducidos */
	static HashMap<Integer, Evento> eventos=new HashMap<>();
	/** Almacena los eventos favoritos de los usuarios*/
	static ArrayList<Favorito> favoritos=new ArrayList<>();
	
	// ============= CONTADORES  =============
	
	
	
	
	

	/**
	 * Método principal para crear objetos y probar las clases del paquete
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// MENÚ CON LAS OPCIONES
		
		Scanner teclado=new Scanner(System.in);
		int user; 
		
		// Muestro Menú
		do {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("MENÚ DE ACCIONES\n 1. Añadir usuario\n 2. Eliminar usuario\n 3. Añadir evento\n 4. Eliminar evento\n 5. Añadir galería\n 6. Eliminar galería\n 7. Añadir favorito\n 8. Eliminar favorito\n 9. Salir");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			
			// Solicito al usuario que ingrese una opción del menú
			System.out.println("Inserte una opción del menú (1-9: ");
			user=teclado.nextInt();
			// Compruebo la validez de la opción introducida
			user=comprobar(user,teclado);
			
			// Despliego opciones
			switch(user) {
				case 1: 
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					System.out.println("Su sesión ha finalizado. Gracias !");
			}
		}while(user!=9);
		teclado.close();
	}
	
	// ============= MÉTODOS PARTICULARES =============
	
	/**
	 * Comprueba la existencia de la opción introducida por el usuario
	 * 
	 * @param user opción introducida
	 * @param teclado objeto para coger datos del usuario
	 * @return user la opción introducida que ya es correcta
	 */
	public static int comprobar(int user, Scanner teclado) {
		while(user < PRIMERA_OPCION_MENU || user > ULTIMA_OPCION_MENU) {
			System.out.println("Opción NO válida.\n ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n MENÚ DE ACCIONES\n 1. Añadir usuario\n 2. Eliminar usuario\n 3. Añadir evento\n 4. Eliminar evento\n 5. Añadir galería\n 6. Eliminar galería\n 7. Añadir favorito\n 8. Eliminar favorito\n 9. Salir\n ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n Introduce una opción del menú (1-9): ");
			user=teclado.nextInt();
		}
		return user;
	}
	/**
	 * Añade usuarios a la colección usuarios
	 * 
	 */
	public static void aniadirUsuario(Scanner teclado) {
		String nombre, email, password;
		System.out.println("Introduce el nombre del usuario: ");
		nombre=teclado.nextLine();
		System.out.println("Introduce email del usuario: ");
		email=teclado.nextLine();
		System.out.println("Introduce la contraseña del usuario: ");
		password=teclado.nextLine();
	}
	
	
	

}
