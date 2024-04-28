package clases;

/**
 * La clase 'CuentaUSD' es una clase hija de {@link Cuenta}.
 * Es la encargada de generar los depositos y retiros de la cuenta.
 * Además, incluye el simbolo de la moneda asignada a esta clase(USD),
 * el factor de conversión que se utiliza para pasar de CLP a USD y
 * la operación que hace esto posible.
 * 
 */
public class CuentaUSD extends Cuenta{

	/**
	 * super constructor de la clase 'CuentaUSD'
	 * @param numeroDeCuenta Numero de la cuenta bancaria, debe se un entero
	 * @param saldoActual Saldo actual de la cuenta, debe ser un double, 
	 * se interpreta como dolar estadounidense
	 */
	public CuentaUSD(int numeroDeCuenta, double saldoActual) {
		super(numeroDeCuenta, saldoActual);
	}
	
	@Override
	public void depositar(double monto) {
		if(monto < 0) {
			System.out.println("\t"+ROJO+"Debe depositar un monto superior a cero."+RESET);
		}else {
			this.saldoActual+=monto;
			transacciones.add(new Deposito(monto));
			System.out.println("\n\t"+VERDE+"Deposito realizado con éxito."+RESET);
			System.out.println("\t"+VERDE+"Tu saldo actual es: "+getSimbolo()+getSaldoActual()+RESET);
		}
	}

	@Override
	public void retirar(double monto) {
		if(this.saldoActual>=monto && monto >0) {
			this.saldoActual-=monto;
			transacciones.add(new Retiro(monto));
			System.out.println("\n\t"+VERDE+"Retiro realizado con éxito."+RESET);
			System.out.println("\n\t"+VERDE+"Tu saldo actual es: "+getSimbolo()+getSaldoActual()+RESET);
		}else {
			System.out.println("\t"+ROJO+"Error, monto a retirar debe ser menor al saldo actual de la cuenta."+RESET);	
		}	
	}

	@Override
	public String getSimbolo() {
		return "$USD";
	}

	@Override
	public double getFactorConversion() {
		return 0.0010432728; //factor de conversion el 21-04-2024
	}

	@Override
	public double convertir(double monto) {
		return Math.round(monto/getFactorConversion());
	}

	

}
