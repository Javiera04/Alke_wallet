package clases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	DepositoTest.class,
	RetiroTest.class
})
public class SuiteTestTransacciones {

}
