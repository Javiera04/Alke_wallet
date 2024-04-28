package clases;

/**
 * Clase que representa una 'Transaccion' de tipo 'Retiro'.
 * Implementa la interfaz {@link Transaccion}
 */
public class Retiro implements Transaccion{
	/**El monto del retiro*/
	private double monto;

	/**
	 * Constructor de la clase 'Retiro'
	 * @param monto el monto del retiro
	 */
    public Retiro(double monto) {
        this.monto = monto;
    }

    @Override
    public String getTipo() {
        return "Retiro";
    }

    @Override
    public double getMonto() {
        return monto;
    }

	@Override
	public String toString() {
		return "\tRetiro [monto=" + monto + "]";
	}
    
    
}
