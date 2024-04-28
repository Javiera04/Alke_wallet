package clases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static clases.Colores.CYAN;
import static clases.Colores.RESET;

/**
 * Esta clase contiene pruebas unitarias de la clase {@link Cuenta}.
 */
class CuentaTest {
	
	Cuenta cuenta;
	
	/**
	 * Configuracion inicial para cada una de las prueba originadas.
	 * @throws Exception ocurre si hay algun error en la configuracion.
	 */
	@BeforeEach
	void setUp() throws Exception {
		cuenta = new CuentaCLP(10,1000);
	}
	
	/**Prueba para el método getSaldoActual()*/
	@Test
	void testGetSaldoActual() {
		assertEquals(1000,cuenta.getSaldoActual());
	}
	
	/**Prueba para el método setSaldoActual()*/
	@Test
	void testSetSaldoActual() {
		cuenta.setSaldoActual(1500);
		assertEquals(1500,cuenta.getSaldoActual());
	}
	
	/**Prueba para el método getNumeroDeCuenta()*/
	@Test
	void testGetNumeroDeCuenta() {
		assertEquals(10,cuenta.getNumeroDeCuenta());
	}
	
	/**Prueba para el método setNumeroDeCuenta()*/
	@Test
	void testSetNumeroDeCuenta() {
		cuenta.setNumeroDeCuenta(5);
		assertEquals(5,cuenta.getNumeroDeCuenta());
	}
	
	/**Prueba para el método getTransacciones()*/
	@Test
	void testTransacciones() {
		Transaccion retiro = new Retiro(100);
		Transaccion deposito = new Deposito(500);
		
		cuenta.getTransacciones().add(retiro);
		cuenta.getTransacciones().add(deposito);
		
		List<Transaccion> transacciones = cuenta.getTransacciones();
		
		assertEquals(2,transacciones.size());
	}
	
	/**Prueba para el método toString()*/
	@Test
	void testToString() {
	    String resultado = CYAN + "numero de cuenta: 10\n\tsaldo actual: CLP$1000.0" + RESET;
	    assertEquals(resultado, cuenta.toString());
	}

	

}
