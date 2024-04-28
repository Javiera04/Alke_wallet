package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Esta clase contiene pruebas unitarias de la clase {@link CuentaUSD}.
 */
class CuentaUSDTest {
	
	CuentaUSD cuentaUsd;
	
	/**
	 * Configuracion inicial para cada una de las prueba originadas.
	 * @throws Exception ocurre si hay algun error en la configuracion.
	 */
	@BeforeEach
	void setUp() throws Exception {
		cuentaUsd = new CuentaUSD(888,10.58);
	}
	
	/**Prueba para el metodo depositar().*/
	@Test
	void testDeposito() {
		cuentaUsd.depositar(25);
		assertEquals(35.58, cuentaUsd.getSaldoActual());
	}
	
	/**Prueba para el método depositar() cuando el monto es menor a 0.*/
	@Test
    void testDepositoConError() {
        double saldoInicial = cuentaUsd.getSaldoActual();
        int transaccionesInicial = cuentaUsd.getTransacciones().size();
        
        cuentaUsd.depositar(-50.0);
        
        assertEquals(saldoInicial, cuentaUsd.getSaldoActual());
        assertEquals(transaccionesInicial, cuentaUsd.getTransacciones().size());
    }
	
	/**Prueba para el metodo retirar()*/
	@Test
	void testRetiro() {
		cuentaUsd.retirar(2.73);
		assertEquals(7.85, cuentaUsd.getSaldoActual());
	}
	
	/**Prueba para el metodo retirar() cuando el monto a retirar supera el saldo actual de la cuenta*/
	@Test
    void testRetiroConError() {
        double saldoInicial = cuentaUsd.getSaldoActual();
        int transaccionesInicial = cuentaUsd.getTransacciones().size();
        
        cuentaUsd.retirar(100.0);
        
        assertEquals(saldoInicial, cuentaUsd.getSaldoActual());
        assertEquals(transaccionesInicial, cuentaUsd.getTransacciones().size());
    }
	
	/**Prueba paara el metodo getSimbolo()*/
	@Test
	void testGetSimbolo() {
		assertEquals("$USD", cuentaUsd.getSimbolo());
	}
	
	/**Prueba para el metoco getFactoConversion()*/
	@Test
	void testGetFactorConversion() {
		assertEquals(0.0010432728, cuentaUsd.getFactorConversion());
	}
	
	/**Prueba para el metodo convertir()*/
	@Test
	void testConvertir() {
        double saldoUSD = cuentaUsd.convertir(19.58);
		assertEquals(18768, saldoUSD);
	}

}
