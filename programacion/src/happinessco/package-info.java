/**
 * Paquete principal de la aplicación web Happiness & Co.
 *
 * <p>Contiene las clases del modelo de datos de la agenda cultural y la clase principal
 * para la gestión mediante un menú de consola.</p>
 *
 * <p>Clases incluidas:</p>
 * <ul>
 *   <li>{@link happinessco.modelo.Usuario} — gestión de usuarios registrados</li>
 *   <li>{@link happinessco.modelo.Evento} — gestión de eventos culturales</li>
 *   <li>{@link happinessco.modelo.Galeria} — gestión de galerías de imágenes</li>
 *   <li>{@link happinessco.modelo.Favorito} — gestión de eventos favoritos por usuario</li>
 *   <li>{@link happinessco.controlador.BaseDeDatos} — gestión de colecciones y lógica del menú</li>
 *   <li>{@link happinessco.vista.Main} — clase principal con el menú de gestión</li>
 * </ul>
 *
 * <p>Las colecciones se gestionan con {@link java.util.HashMap} y
 * {@link java.util.ArrayList}.</p>
 *
 * @author Sara Pérez Rodríguez
 * @version 1.0
 */
package happinessco;