package happinessco.modelo;

/**
 * Esta clase gestiona los eventos favoritos de los usuarios
 * 
 * <p> Registra el correo del usuario (único) y el identficador del evento <p>
 * 
 */
public class Favorito {
	
	    // ============= ATRIBUTOS =============
	
		/** Correo del usuario. */
		private String correoUsuario;
		/** Identificador del evento. */
		private int idEvento;


		// ============= CONSTRUCTOR =============
		
		/**
		 * Crea un nuevo evento favorito asociado a un usuario
		 * 
		 * @param correoUsuario Correo asociado al usuario y que es unívoco
		 * @param idEvento		Identificador del evento que será favorito
		 * 
		 */
		
		public Favorito(String correoUsuario, int idEvento) {
			this.correoUsuario=correoUsuario;
			this.idEvento=idEvento;
		}

		// ============= GETTERS Y SETTERS =============
		
		/**
		 * Devuelve el correo electrónico del usuario
		 * 
		 * @return correoUsuario
		 */
		public String getCorreoUsuario() {
			return correoUsuario;
		}


		/**
		 * Establece el correo electrónico del usuario
		 * 
		 * @param correoUsuario correo del usuario
		 */
		public void setCorreoUsuario(String correoUsuario) {
			this.correoUsuario = correoUsuario;
		}


		/**
		 * Devuelve el id del evento
		 * 
		 * @return idEvento
		 */
		public int getIdEvento() {
			return idEvento;
		}


		/**
		 * Establece el id de un evento
		 * 
		 * @param idEvento id del evento
		 */
		public void setIdEvento(int idEvento) {
			this.idEvento = idEvento;
		}


		// ============= TOSTRING =============
		
		@Override
		/**
		 * Imprime los datos de los eventos favoritos de los usuarios
		 * 
		 * @return Formato de impresión para los datos de los favoritos
		 */
		public String toString() {
			return String.format("Favorito ---> correoUsuario=%s\n\t\t\tidEvento=%d\n", 
					correoUsuario, idEvento);
		}

}
