package happinessco;

/**
 * Esta clase gestiona el registro de Usuarios
 * 
 * <p> Guarda su nombre, email y contraseña <p>
 * 
 */
public class Usuario {
	
	// ============= ATRIBUTOS =============
	
	/** Nombre del usuario. */
	private String nombre;
	/** Email único del usuario. */
	private String email;
	/** Contraseña del usuario */
	private String password;


	// ============= CONSTRUCTOR =============
	
	/**
	 * Crea un nuevo usuario con todos sus parámetros
	 * 
	 * @param nombre Nombre del usuario insertado
	 * @param email  Email único asociado al usuario
	 * @param password Contraseña insertada por el usuario
	 * 
	 * 
	 */
	
	public Usuario(String nombre, String email, String password) {
		this.nombre=nombre;
		this.email=email;
		this.password=password;
		
	}

	// ============= GETTERS Y SETTERS =============
	
	/**
	 * Devuelve el nombre del usuario
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Establece el nombre del usuario
	 * 
	 * @param nombre nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Devuelve el email del usuario
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Establece el email del usuario
	 * 
	 * @param email email del usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Devuelve la contraseña del usuario
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Establece la contraseña del usuario
	 * 
	 * @param password contrasela del usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	// ============= TOSTRING =============
	
	@Override
	/**
	 * Imprime los datos del usuario
	 * 
	 * @return Formato de impresión para los datos del usuario
	 */
	public String toString() {
		return String.format("Usuario ---> nombre=%s\n\t\t\temail=%s\n\t\t\tpassword=%s\n", 
				nombre, email, password);
	}

}
