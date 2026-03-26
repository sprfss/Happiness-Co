package happinessco;

import java.util.ArrayList;

/**
 * Esta clase gestiona el registro de eventos
 * 
 * <p> Registra identificador, fecha, título, ubicación, descripción y la galería asociada al evento <p>
 * 
 */
public class Evento {
	

	// ============= ATRIBUTOS =============
	
		/** Identificador del evento */
		private int id;
		/** Fecha del evento */
		private String fecha;
		/** Titulo del evento */
		private String titulo;
		/** Ubicación del evento */
		private String ubicacion;
		/** Descripción del evento */
		private String descripcion;
		/** Galería del evento, referenciando la clase Galeria a la que realmente pertenece la galeria */
		private ArrayList<Galeria> galerias;
		


		// ============= CONSTRUCTOR =============
		
		/**
		 * Crea un nuevo evento con todos sus parámetros
		 * 
		 * @param id 	 		Identificador del evento
		 * @param fecha  		Fecha cuando se realiza el evento
		 * @param titulo 		Titulo del evento
		 * @param ubicacion 	Sitio/Plataforma donde se desarrolla el evento
		 * @param descripcion	Breve descripción del evento
		 * @param galerias 		Galería de imágenes asociada al evento
		 * 
		 * 
		 */
		
		public Evento(int id, String fecha, String titulo, String ubicacion, String descripcion) {
			this.id=id;
			this.fecha=fecha;
			this.titulo=titulo;
			this.ubicacion=ubicacion;
			this.descripcion=descripcion;
			this.galerias = new ArrayList<>();
			
		}

		// ============= GETTERS Y SETTERS =============
		
		/**
		 * Devuelve el id del evento
		 * 
		 * @return id
		 */
		public int getId() {
			return id;
		}


		/**
		 * Establece el id del evento
		 * 
		 * @param id id del evento
		 */
		public void setId(int id) {
			this.id = id;
		}


		/**
		 * Devuelve la fecha del evento
		 * 
		 * @return fecha
		 */
		public String getFecha() {
			return fecha;
		}


		/**
		 * Establece la fecha del evento
		 * 
		 * @param fecha fecha del evento
		 */
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}


		/**
		 * Devuelve el titulo del evento
		 * 
		 * @return titulo
		 */
		public String getTitulo() {
			return titulo;
		}


		/**
		 * Establece el titulo del evento
		 * 
		 * @param titulo titulo del evento
		 */
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		/**
		 * Devuelve la ubicacion del evento
		 * 
		 * @return ubicacion
		 */
		public String getUbicacion() {
			return ubicacion;
		}


		/**
		 * Establece la ubicacion del evento
		 * 
		 * @param ubicacion ubicacion del evento
		 */
		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}
		
		/**
		 * Devuelve la descripción del evento
		 * 
		 * @return descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}


		/**
		 * Establece la descripcion del evento
		 * 
		 * @param descripcion descripcion del evento
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		/**
		 * Devuelve la galeria del evento
		 * 
		 * @return galerias
		 */
		public ArrayList<Galeria> getGalerias() {
			return galerias;
		}


		/**
		 * Establece la galeria del evento
		 * 
		 * @param galeria galeria del evento
		 */
		public void setGalerias(ArrayList<Galeria> galerias) {
			this.galerias = galerias;
		}


		
		// ============= TOSTRING =============
		
		@Override
		/**
		 * Imprime los datos de un evento
		 * 
		 * @return Formato de impresión para los datos de un evento
		 */
		public String toString() {
			return String.format("Evento ---> id= %d\n\t\t\tfecha= %s\n\t\t\ttítulo= %s\n\t\t\tubicación= %s\n\t\t\tdescripción= %s\n\t\t\tcolección de galerías= %s\n", 
					id, fecha, titulo, ubicacion, descripcion, galerias);
			
		}
		
}
