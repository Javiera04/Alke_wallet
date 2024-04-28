package clases;

/**
 * La clase 'Cliente' representa a un cliente de la billetera virtual.
 * Almacena información personal del cliente, como nombre, rut y cuenta.
 * Además, esta encargado de generar la operación de conversión de moneda.
 * Un cliente debe estar asociado a una {@link Cuenta}.
 */
public class Cliente implements Colores{
	/**
	 * Rut del cliente
	 */
	private String rut;
	/**
	 * Nombre completo del cliente
	 */
	private String nombreCompleto;
	/**
	 * Informacion extraida de la clase cuenta: numeroDeCuenta, saldoActual y titular
	 */
	private Cuenta cuenta;
	
	/**
	 * Constructor de la clase 'Cliente'
	 * @param rut rut del cliente, debe ser un String
	 * @param nombreCompleto nombre completo del cliente, debe ser un String
	 * @param cuenta informacion desde la clase cuenta: numeroDeCuenta, saldoActual
	 */
	public Cliente(String rut, String nombreCompleto, Cuenta cuenta) {
		this.rut = rut;
		this.nombreCompleto = nombreCompleto;
		this.cuenta = cuenta;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	/**
	 * Permite que el cliente seleccione el tipo de moneda para su cuenta.
	 * 
	 * Si el tipo de moneda seleccionado es CLP y la cuenta actual es USD,
	 * convierte el saldo de la cuenta a CLP y actualiza la cuenta.
	 * Si el tipo de moneda seleccionado es USD y la cuenta actual es CLP,
	 * convierte el saldo de la cuenta a USD y actualiza la cuenta.
	 * Si el tipo de moneda seleccionado coincide con el tipo actual muestra 
	 * un mensaje de error.
	 * Si el tipo de moneda seleccionado no coincide con ninguna opción 
	 * muestra un mensaje de error.
	 * 
	 * @param tipoMoneda El tipo de moneda que se desea convertir (1 es CLP, 2 es USD)
	 */
	public void seleccionarMoneda(int tipoMoneda) {
	    if (1 == tipoMoneda && !(cuenta instanceof CuentaCLP)) {
	        // Convertir a cuenta CLP
	        double saldoUSD = cuenta.getSaldoActual();
	        double saldoCLP = cuenta.convertir(saldoUSD);
	        setCuenta(new CuentaCLP(cuenta.getNumeroDeCuenta(), saldoCLP));
	        System.out.println("\t"+VERDE+"La cuenta fue convertida con éxito."+RESET);
	    } else if (2 == tipoMoneda && !(cuenta instanceof CuentaUSD)) {
	        // Convertir a cuenta USD
	        double saldoCLP = cuenta.getSaldoActual();
	        double saldoUSD = cuenta.convertir(saldoCLP); 
	        setCuenta(new CuentaUSD(cuenta.getNumeroDeCuenta(), saldoUSD));
	        System.out.println("\t"+VERDE+"La cuenta fue convertida con éxito."+RESET);
	    } else {
	    	if(tipoMoneda == 2) {
	    		System.out.println("\t"+ROJO+"La cuenta ya es de tipo USD"+RESET);
	    	}else if (tipoMoneda == 1){
	    		System.out.println("\t"+ROJO+"La cuenta ya es de tipo CLP"+RESET);
	    	}else {
	    		System.out.println("\t"+ROJO+"Opción no válida"+RESET);
	    	}
	        
	    }
	}

	@Override
	public String toString() {
		return "\t"+CYAN+"rut: " + rut + "\n\tnombre: " + nombreCompleto + "\n\t" + cuenta+RESET;
	}

	
	
}
