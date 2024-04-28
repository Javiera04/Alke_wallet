package clases;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase 'Cuenta' representa una cuenta en la billetera virtual.
 * Almacena informacion de la cuenta, como numero de cuenta, saldo y transacciones
 * Esta clase padre genera los metodos con el que sus hijas pueden realizar la accion
 * de depositar y retirar saldo.
 * Implementa {@link Moneda} y de manera implicita {@link Transaccion}.
 */
public abstract class Cuenta implements Moneda, Colores{
	/**
	 * Numero de cuenta bancaria
	 */
	protected int numeroDeCuenta;
	/**
	 * Saldo de la cuenta bancaria
	 */
	protected double saldoActual;

	/**
	 * Lista encargada de guardar las transacciones de la cuenta
	 */
	protected List<Transaccion> transacciones;
	
	/**
	 * Constructor de la clase 'Cuenta'
	 * @param numeroDeCuenta  Numero de la cuenta bancaria, debe se un entero
	 * @param saldoActual  Saldo actual de la cuenta, debe ser un double
	 * 
	 */
	public Cuenta(int numeroDeCuenta, double saldoActual) {
		this.numeroDeCuenta = numeroDeCuenta;
		this.saldoActual = saldoActual;
		this.transacciones = new ArrayList<>();
	}

	public int getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(int numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public double getSaldoActual() {
		return Math.round(saldoActual*100)/100d;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public List<Transaccion> getTransacciones() {
        return transacciones;
    }
	
	/*Metodos custom*/
	/**
	 * Metodo que permite depositar saldo en la cuenta.
	 * 
	 * Si el monto es menor que cero, muestra un mensaje de error.
	 * De lo contrario, suma el monto al saldo actual de la cuenta,
	 * lo agrega a la lista de transacciones de la categoria 'Deposito' 
	 * y muestra un mensaje de éxito.
	 * 
	 * @param monto  numero a depositar, debe ser un double
	 */
	public abstract void depositar(double monto) ;
	
	
	/**
	 * Metodo que permite retirar saldo de la cuenta.
	 * 
	 * Si el saldo actual de la cuenta es mayor o igual al monto y el monto es mayor que
	 * cero, se resta el saldo actual con el monto, lo agrega a la lista de transacciones
	 * de la categoria 'Retiro' y muestra un mensaje de éxito.
	 * De lo contrario, muestra un mensaje de error.
	 * 
	 * @param monto numero a retirar, debe ser un double
	 */
	public abstract void retirar(double monto);

	
	@Override
	public String toString() {
		return CYAN+"numero de cuenta: " + numeroDeCuenta + "\n\tsaldo actual: " +getSimbolo() +saldoActual+RESET;
	}
	
	
	
}
