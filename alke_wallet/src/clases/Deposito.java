package clases;

/**
 * Clase que representa una 'Transaccion' de tipo 'Deposito'.
 * Implementa la interfaz {@link Transaccion}
 */
public class Deposito implements Transaccion{
	/**El monto del deposito*/
	private double monto;

	/**
	 * Constructor de la clase 'Deposito'
	 * @param monto el monto del deposito
	 */
    public Deposito(double monto) {
        this.monto = monto;
    }

    @Override
    public String getTipo() {
        return "Depósito";
    }

    @Override
    public double getMonto() {
        return monto;
    }

	@Override
	public String toString() {
		return "\tDeposito [monto=" + monto + "]";
	}
    
    
}
