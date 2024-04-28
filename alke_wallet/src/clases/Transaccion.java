package clases;

/**
 * Esta interface representa los tipos de transacciones que puede realizar
 * una cuenta.
 */
public interface Transaccion {
	/**Obtiene el tipo de transacción*/
	String getTipo();
	/**Obtiene el monto de transacción*/
    double getMonto();
}
