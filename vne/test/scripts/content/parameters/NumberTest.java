/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.content.parameters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class NumberTest {
    
    public NumberTest() {
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

    /**
     * Test of getAsString method, of class Number.
     */
    @Test
    public void testGetAsString() {
        System.out.println("getAsString");
        Number n1 = new Number("15");
        assertEquals("15", n1.getAsString());
        
        Number n2 = new Number(15);
        assertEquals("15", n2.getAsString());
        
        Number n3 = new Number((long) 0.5);
        assertEquals("0", n3.getAsString());
    }

    /**
     * Test of hashCode method, of class Number.
     */
    @Test
    public void testHashCode() {
        
    }

    /**
     * Test of equals method, of class Number.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Number n1 = new Number(1);
        
        Number n2 = new Number(1);
        assertTrue(n1.equals(n2));
        
        Number n3 = new Number("1");
        assertTrue(n1.equals(n3));
        
        Number n4 = new Number(2);
        assertFalse(n1.equals(n4));
    }
    
}
