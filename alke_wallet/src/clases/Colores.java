package clases;

/**
 * Esta interface define constantes para colores de texto en la consola.
 */
public interface Colores {
	/**Representa el color rojo en código ANSI*/
	final String ROJO = "\033[31m";
	/**Representa el color verde en código ANSI*/
	final String VERDE = "\033[32m";
	/**Representa el color cyan en código ANSI*/
	final String CYAN = "\033[36m";
	/**Representa el reinicio de color en código ANSI*/
	final String RESET = "\u001B[0m";
}
