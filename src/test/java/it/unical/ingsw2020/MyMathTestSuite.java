package it.unical.ingsw2020;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//esegue i test sulle classi indicate nell'ordine specificato In questo caso MyMathTest verra eseguito dopo Parameterized
@RunWith(Suite.class)
@SuiteClasses({ParameterizedMathTest.class, MyMathTest.class})
public class MyMathTestSuite {

}
