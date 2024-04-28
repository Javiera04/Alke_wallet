package clases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CuentaTest.class,
	CuentaCLPTest.class,
	CuentaUSDTest.class
})
public class SuiteTestCuenta {

}
