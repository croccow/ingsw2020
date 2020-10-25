package it.unical.ingsw2020;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.Mockito.*;

//facendo il coverage ci accorgiamo dei test che vengono eseguiti e di quelli che non vengono eseguiti 
public class MyMathTest {

	private static MyMath myMath;
	
	//mock oggetto finto creato da mockito che è una libreria che permette di controllare un determinato oggetto come voglio
	@Mock
	private ConnectionManager connectionManagerMock;
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	//viene eseguito 1 sola volta ....beforeClass e afterClass vengono usati con metodi statici
	@BeforeClass
	public static void prepareAll() {
		System.out.println("before class");
		myMath = new MyMath();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

	@Before
	public void prepareTest() {
		System.out.println("before");
		myMath = new MyMath(connectionManagerMock);
	}

	@After
	public void cleanTest() {
		System.out.println("after");
	}
	
	//questo test avrà successo se verrà lanciata l'eccezione indicata nelle parentesi
	@Test(expected = IllegalArgumentException.class)
	public void fibonacciThrowsException() {
		System.out.println("fibonacciThrowsException");
		myMath.fibonacci(-1);
	}
	
	//in assert equals il primo argomento è quello che ci aspettiamo come risultato se non è quello indicato il test fallisce
	@Test
	public void fibonacciWorks() {
		System.out.println("testing that fibonacci works");
		assertEquals(1, myMath.fibonacci(1));
		assertEquals(8, myMath.fibonacci(5));
		assertEquals(13, myMath.fibonacci(6));
	}

	@Test
	public void factorialWorks() {
		System.out.println("testing that factorial works");
		assertEquals(1,myMath.factorial(0));
		assertEquals(120, myMath.factorial(5));
	}
	//se quello che ci aspettiamo non viene restituito dopo 5 secondi il test fallisce
	@Test(timeout = 5000)
	public void fibonacciIsFastEnough() {
		System.out.println("fibonacciIsFastEnough");
		myMath.fibonacci(1);
	}
	//qua invece il test va abuon fine se i primi due valori sono uguali o differiscono al massimo 0.001
	@Test
	public void testOnDoubles() {
		System.out.println("testOnDoubles");
		assertEquals(0.3, 0.1 + 0.1 + 0.1, 0.001);
	}
	
	/**
	 * Just to show that we can modify the Mocked instance behavior
	 */
	@Test
	public void remoteFactorialWorks() {
		System.out.println("testing that remoteFactorial Works");	
		when(connectionManagerMock.isNetworkConnected()).thenReturn(true);
		assertEquals(12345678, myMath.remoteFactorial(2));
	}

	/**
	 * Just to show that we can modify the Mocked instance behavior
	 */
	@Test(expected = RuntimeException.class)
	public void remoteFactorialThrowsException() {
		System.out.println("testing that remoteFactorial throws");	
		when(connectionManagerMock.isNetworkConnected()).thenReturn(false);
		myMath.remoteFactorial(5);
	}
	
}
