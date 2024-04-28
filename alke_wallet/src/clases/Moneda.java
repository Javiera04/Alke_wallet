package clases;

/**
 * Interface que define campos clave para las clases moneda
 * como por ejemplo, simbolo de la moneda, factor de conversion y el metodo convertir.
 */
public interface Moneda {
	/**
	 * Metodo que solicita un simbolo para diferenciar las monedas
	 * @return retorna un simbolo, ej: "$"
	 */
	String getSimbolo();
	
	/**
	 * Metodo que retorna un factor de conversion
	 * @return retorna el factor de conversion de la moneda, ej: 0.001
	 */
	double getFactorConversion();
	
	/**
	 * Metodo que convierte de una moneda a otra
	 * @param monto monto que se va a convertir
	 * @return retorna el monto convertido
	 */
	double convertir(double monto);
}
