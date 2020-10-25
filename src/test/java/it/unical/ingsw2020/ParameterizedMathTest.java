package it.unical.ingsw2020;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class ParameterizedMathTest {
	
	private int expected;
	private int n;
		
	public ParameterizedMathTest(int expected, int n) {
		super();
		this.expected = expected;
		this.n = n;
	}

	@Parameters
	public static Collection<Object[]> getParameters() {		
		return Arrays.asList(new Object[][] {{1,0}, {1,1}, {5,4}});
	}
	
	//questo test sarà eseguito 3 vlte perche sopra nella funzione dei Parameters abbiamo messo 3 valori
	//il tutto avviene in automatico
	@Test
	public void fibonacciWorks() {
		MyMath myMath = new MyMath();
		assertEquals(expected, myMath.fibonacci(n));
	}

}
