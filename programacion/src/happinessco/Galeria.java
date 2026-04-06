package happinessco;

/**
 * Esta clase gestiona las galerías de los eventos
 * 
 * <p> Registra cada galería con un identificador, un título de galería y el identicador del evento asociado <p>
 * 
 */
public class Galeria {
	
	    // ============= ATRIBUTOS =============
	
		/** Identificador de la galería. */
		private int id;
		/** Título de la galería. */
		private String titulo;
		/** Identificador asociado al evento */
		private int idEvento;


		// ============= CONSTRUCTOR =============
		
		/**
		 * Crea una nueva galería con todos sus parámetros
		 * 
		 * @param id 		Identificador de la galería
		 * @param titulo    Nombre de la galería
		 * @param idEvento  Id del evento asociado a esa galería
		 * 
		 */
		
		public Galeria(int id, String titulo, int idEvento) {
			this.id=id;
			this.titulo=titulo;
			this.idEvento=idEvento;
			
		}

		// ============= GETTERS Y SETTERS =============
		
		/**
		 * Devuelve el id de la galería
		 * 
		 * @return id
		 */
		public int getId() {
			return id;
		}


		/**
		 * Establece el id de la galería
		 * 
		 * @param id id de la galería
		 */
		public void setId(int id) {
			this.id = id;
		}


		/**
		 * Devuelve el titulo de la galería
		 * 
		 * @return titulo
		 */
		public String getTitulo() {
			return titulo;
		}


		/**
		 * Establece el título de la galería
		 * 
		 * @param titulo título de la galería
		 */
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		/**
		 * Devuelve el id del evento asociado
		 * 
		 * @return idEvento
		 */
		public int getIdEvento() {
			return idEvento;
		}


		/**
		 * Establece el id del evento asociado
		 * 
		 * @param idEvento id del evento
		 */
		public void setIdEvento(int idEvento) {
			this.idEvento = idEvento;
		}

		
		// ============= TOSTRING =============
		
		@Override
		/**
		 * Imprime los datos de las galerías
		 * 
		 * @return Formato de impresión para los datos de la galería
		 */
		public String toString() {
			return String.format("Galería ---> id=%d\n\t\t\ttitulo=%s\n\t\t\tid evento=%d\n", 
					id, titulo, idEvento);
		}

	}

