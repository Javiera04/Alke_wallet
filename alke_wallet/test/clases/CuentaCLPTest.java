package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Esta clase contiene pruebas unitarias de la clase {@link CuentaCLP}.
 */
class CuentaCLPTest {

	CuentaCLP cuentaClp;
	
	/**
	 * Configuracion inicial para cada una de las prueba originadas.
	 * @throws Exception ocurre si hay algun error en la configuracion.
	 */
	@BeforeEach
	void setUp() throws Exception {
		cuentaClp = new CuentaCLP(5698,18995);
	}
	
	/**Prueba para el metodo depositar().*/
	@Test
	void testDeposito() {
		cuentaClp.depositar(100);
		assertEquals(19095, cuentaClp.getSaldoActual());
	}
	
	/**Prueba para el método depositar() cuando el monto es menor a 0.*/
	@Test
    void testDepositoConError() {
        double saldoInicial = cuentaClp.getSaldoActual();
        int transaccionesInicial = cuentaClp.getTransacciones().size();
        
        cuentaClp.depositar(-50.0);
        
        assertEquals(saldoInicial, cuentaClp.getSaldoActual());
        assertEquals(transaccionesInicial, cuentaClp.getTransacciones().size());
    }
	
	/**Prueba para el metodo retirar()*/
	@Test
	void testRetiro() {
		cuentaClp.retirar(100);
		assertEquals(18895, cuentaClp.getSaldoActual());
	}
	
	/**Prueba para el metodo retirar() cuando el monto a retirar supera el saldo actual de la cuenta*/
	@Test
    void testRetiroConError() {
        double saldoInicial = cuentaClp.getSaldoActual();
        int transaccionesInicial = cuentaClp.getTransacciones().size();
        
        cuentaClp.retirar(250000);
        
        assertEquals(saldoInicial, cuentaClp.getSaldoActual());
        assertEquals(transaccionesInicial, cuentaClp.getTransacciones().size());
    }
	
	/**Prueba paara el metodo getSimbolo()*/
	@Test
	void testGetSimbolo() {
		assertEquals("CLP$", cuentaClp.getSimbolo());
	}
	
	/**Prueba para el metoco getFactoConversion()*/
	@Test
	void testGetFactorConversion() {
		assertEquals(958.522, cuentaClp.getFactorConversion());
	}
	
	/**Prueba para el metodo convertir()*/
	@Test
	void testConvertir() {
        double saldoCLP = cuentaClp.convertir(65498);
		assertEquals(68.33, saldoCLP);
	}
	
}
