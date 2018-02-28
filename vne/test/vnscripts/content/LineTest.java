/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.content;

import vnscripts.content.Line;
import vnscripts.content.Parameter;
import java.util.List;
import java.util.function.BiConsumer;
import objects.Progress;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vnscripts.content.parameters.Text;

/**
 *
 * @author ivan
 */
public class LineTest {
    
    public LineTest() {
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
     * Test of hashCode method, of class Line.
     */
    @Test
    public void testHashCode() {
        
    }

    /**
     * Test of equals method, of class Line.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        BiConsumer<Progress, List<Parameter>> a1 = (p, l) -> System.out.println("Test1");
        BiConsumer<Progress, List<Parameter>> a2 = (p, l) -> System.out.println("Test2");
        Parameter t1 = new Text("foo");
        Parameter t2 = new Text("bar");
        Line l1 = new Line(a1, t1);
        
        Line l2 = new Line(a1, t1);
        assertTrue(l1.equals(l2));
        
        Line l3 = new Line(a2, t1);
        assertFalse(l1.equals(l3));
        
        Line l4 = new Line(a1, t2);
        assertFalse(l1.equals(l4));
    }
    
}
