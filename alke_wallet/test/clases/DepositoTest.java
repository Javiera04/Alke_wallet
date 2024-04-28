package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Esta clase contiene pruebas unitarias de la clase {@link Deposito}.
 */
class DepositoTest {

	Deposito deposito;
	
	/**
	 * Configuracion inicial para cada una de las prueba originadas.
	 * @throws Exception ocurre si hay algun error en la configuracion.
	 */
	@BeforeEach
	void setUp() throws Exception {
		deposito = new Deposito(10.58);
	}
	
	/**Prueba para el metodo getTipo()*/
	@Test
	void testGetTipo() {
		assertEquals("Depósito", deposito.getTipo());
	}
	
	/**Prueba para el metodo getMonto()*/
	@Test
	void testGetMonto() {
		assertEquals(10.58, deposito.getMonto());
	}
	
	/**Prueba para el metodo toString()*/
	@Test
	void testToString() {
		assertEquals("\tDeposito [monto=10.58]", deposito.toString());
	}

}
