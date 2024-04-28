package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Esta clase contiene pruebas unitarias de la clase {@link Retiro}.
 */
class RetiroTest {

	Retiro retiro;
	
	/**
	 * Configuracion inicial para cada una de las prueba originadas.
	 * @throws Exception ocurre si hay algun error en la configuracion.
	 */	
	@BeforeEach
	void setUp() throws Exception {
		retiro = new Retiro(248978);
	}
	
	/**Prueba para el metodo getTipo()*/
	@Test
	void testGetTipo() {
		assertEquals("Retiro", retiro.getTipo());
	}
	
	/**Prueba para el metodo getMonto()*/
	@Test
	void testGetMonto() {
		assertEquals(248978, retiro.getMonto());
	}
	
	/**Prueba para el metodo toString()*/
	@Test
	void testToString() {
		assertEquals("\tRetiro [monto=248978.0]", retiro.toString());
	}

}
