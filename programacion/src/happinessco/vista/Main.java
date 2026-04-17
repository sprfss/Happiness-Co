package happinessco.vista;

// Importo paquetes utilizados
import java.util.Scanner;

import happinessco.controlador.BaseDeDatos;

/**
 * Clase principal
 * 
 * <p> Muestra el menú de opciones al usuario y delega cada acción
 * en la clase {@link BaseDeDatos}. Contiene el método ejecutable<p>
 * 
 */
public class Main {
	
	// ============= CONSTANTES =============
	
	/** Entero válido menor que forma parte de las opciones del menú */
	final static int PRIMERA_OPCION_MENU = 1;
	/** Entero válido mayor que forma parte de las opciones del menú */
	final static int ULTIMA_OPCION_MENU = 9;
	
	// ============= MÉTODO PRINCIPAL =============
	
	/**
	 * Método principal
	 * 
	 * <p> Despliega el menú de acciones <p>
	 * 
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		// Abro el flujo del teclado
		Scanner teclado=new Scanner(System.in);
		int user; 
		
		// Muestro Menú
		do {
			mostrarMenu();
			// Solicito al usuario que ingrese una opción del menú
			System.out.println("Inserte una opción del menú (1-9): ");
			user=teclado.nextInt();
			// Compruebo la validez de la opción introducida
			user=comprobar(user,teclado);
			
			// Despliego opciones
			switch(user) {
				case 1: 
					BaseDeDatos.aniadirUsuario(teclado);
					break;
				case 2:
					BaseDeDatos.eliminarUsuario(teclado);
					break;
				case 3:
					BaseDeDatos.aniadirEvento(teclado);
					break;
				case 4:
					BaseDeDatos.eliminarEvento(teclado);
					break;
				case 5:
					BaseDeDatos.aniadirGaleria(teclado);
					break;
				case 6:
					BaseDeDatos.eliminarGaleria(teclado);
					break;
				case 7:
					BaseDeDatos.aniadirFavorito(teclado);
					break;
				case 8:
					BaseDeDatos.eliminarFavorito(teclado);
					break;
				case 9:
					System.out.println("Su sesión ha finalizado. Gracias !");
			}
		}while(user!=9);
		// Cierro el flujo del teclado 
		teclado.close();
	}
	
	// ============= MÉTODOS PARTICULARES =============
	
	/**
	 * Muestra el menú de opciones por pantalla
	 */
	private static void mostrarMenu() {
		System.out.println("-------------------------");
		System.out.println("MENÚ DE ACCIONES\n 1. Añadir usuario\n 2. Eliminar usuario\n 3. Añadir evento\n 4. Eliminar evento\n 5. Añadir galería\n 6. Eliminar galería\n 7. Añadir favorito\n 8. Eliminar favorito\n 9. Salir");
		System.out.println("-------------------------");
	}
	
	/**
	 * Comprueba la existencia de la opción introducida por el usuario
	 * 
	 * @param user opción introducida
	 * @param teclado objeto para coger datos del usuario
	 * @return user la opción introducida que ya es correcta
	 */
	private static int comprobar(int user, Scanner teclado) {
		while(user < PRIMERA_OPCION_MENU || user > ULTIMA_OPCION_MENU) {
			System.out.println("Opción NO válida.");
			mostrarMenu();
			System.out.println("Introduce una opción del menú (1-9): ");
			user=teclado.nextInt();
		}
		return user;
	}
}
