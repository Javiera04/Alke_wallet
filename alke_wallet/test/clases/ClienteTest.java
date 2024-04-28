package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static clases.Colores.CYAN;
import static clases.Colores.RESET;

/**
 * Esta clase contiene pruebas unitarias de la clase {@link Cliente}.
 */
class ClienteTest {
	Cliente cliente;
	CuentaCLP cuentaCLP;
	CuentaUSD cuentaUSD;
	
	/**
	 * Configuracion inicial para cada una de las prueba originadas.
	 * @throws Exception ocurre si hay algun error en la configuracion.
	 */
	@BeforeEach
	void setUp() throws Exception {
		cuentaUSD = new CuentaUSD(10,1500);
		cuentaCLP = new CuentaCLP(10,1000);
		cliente = new Cliente("1-1","Javiera",cuentaCLP);

	}
	
	/**Prueba para el metodo getNombre().*/
	@Test
	void testGetNombre() {
		assertEquals("Javiera",cliente.getNombreCompleto());
	}

	/**Prueba para el metodo setNombre().*/
	@Test
	void testSetNombre() {
		cliente.setNombreCompleto("Fran");
		assertEquals("Fran",cliente.getNombreCompleto());
	}
	
	/**Prueba para el metodo getRut().*/
	@Test
	void testGetRut() {
		assertEquals("1-1",cliente.getRut());
	}
	
	/**Prueba para el metodo setRut().*/
	@Test
	void testSetRut() {
		cliente.setRut("2-2");
		assertEquals("2-2",cliente.getRut());
	}
	
	/**Prueba para el metodo seleeccionarMoneda() cuando se convierte una cuenta a CLP.*/
	@Test
	void testConvertirCuentaCLP() {
		cliente.setCuenta(cuentaUSD);
		cliente.seleccionarMoneda(1);
		assertTrue(cliente.getCuenta() instanceof CuentaCLP);
	}
	
	/**Prueba para el metodo seleeccionarMoneda() cuando la cuenta ya es CLP.*/
	@Test
	void testCuentaYaEsCLP() {
		cliente.setCuenta(cuentaCLP);
		cliente.seleccionarMoneda(1);
		assertTrue(cliente.getCuenta() instanceof CuentaCLP);
	}
	
	/**Prueba para el metodo seleeccionarMoneda() cuando se convierte una cuenta a USD.*/
	@Test
	void testConvertirCuentaUSD() {
		cliente.setCuenta(cuentaCLP);
		cliente.seleccionarMoneda(2);
		assertTrue(cliente.getCuenta() instanceof CuentaUSD);
	}
	
	/**Prueba para el metodo seleeccionarMoneda() cuando la cuenta ya es USD.*/
	@Test
	void testCuentaYaEsUSD() {
		cliente.setCuenta(cuentaUSD);
		cliente.seleccionarMoneda(2);
		assertTrue(cliente.getCuenta() instanceof CuentaUSD);
	}
	
	/**Prueba para el metodo seleeccionarMoneda() cuando se selecciona una opción inválida.*/	
	@Test
	void testCuentaInvalida() {
		cliente.setCuenta(cuentaUSD);
		cliente.seleccionarMoneda(3);
		assertTrue(cliente.getCuenta() instanceof CuentaUSD);
	}
	
	/**Prueba para el metodo toString().*/
	@Test
	void testToString() {
	    String resultado = "\t" + CYAN + "rut: 1-1\n\tnombre: Javiera\n\t" + cuentaCLP + RESET;
	    assertEquals(resultado, cliente.toString());
	}

	
}
