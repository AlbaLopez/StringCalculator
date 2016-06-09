/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.String;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class StringCalculatorTest {   
    
             
    @Test
    public void TestCanInitializeStringCalculator() throws Exception { 
        StringCalculator calculator = new StringCalculator();
            assertNotNull(calculator);      
    }
    
    @Test
    public void TestCadenaNoNula() throws Exception {
        String cadena = " ";
        StringCalculator calculator = new StringCalculator();
        assertNotNull(calculator.Add(cadena));
    }
    
    
    /*public StringCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
