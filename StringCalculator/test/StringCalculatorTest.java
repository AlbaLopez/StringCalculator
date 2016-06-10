/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import StringCalculator.StringCalculator;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.String;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void TestCanInitializeStringCalculator() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertNotNull(calculator);
    }

    @Test
    public void TestCadenaNoNula() throws Exception {
        String cadena = "123";
        StringCalculator calculator = new StringCalculator();
        assertNotNull(calculator.Add(cadena));
    }

    @Test
    public void TestSepararNumeros() throws Exception {
        String cadena = "2,3\n5";
        StringCalculator calculator = new StringCalculator();
        assertNotNull(calculator.divideNumSum(cadena));
    }

    @Test
    public void TestExtractNumbers() throws Exception {
        StringCalculator calculator = new StringCalculator();
        String delimitador = ";|a";
        String cadena = "2;3a5";
        assertNotNull(calculator.extractNumbers(delimitador, cadena));
    }

    @Test
    public void TestClearString() throws Exception {
        StringCalculator calculator = new StringCalculator();
        String cadena = "[prueba][uno]";
        assertNotNull(calculator.clearString(cadena));
        assertEquals("prueba", calculator.clearString(cadena)[0]);
        assertEquals("uno", calculator.clearString(cadena)[1]);

    }

}
