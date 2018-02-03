/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.validator;

import java.util.List;
import java.util.function.BiConsumer;
import objects.Progress;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import scripts.content.Line;
import scripts.content.Parameter;
import scripts.content.parameters.Text;

/**
 *
 * @author ivan
 */
public class CommandTest {
    
    public CommandTest() {
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
     * Test of apply method, of class Command.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        BiConsumer<Progress, List<Parameter>> action = (p, l) -> System.out.println("Command action");
        Command cmd = new Command("test", action, Text.factory, false);
        Line line = new Line(action, new Text("foo"));
        
        try{
            cmd.apply("banana foo");
            fail("The wrong command name was given, the method should've crashed.");
        }catch(IllegalArgumentException e){
            assertTrue(true);
        }
        
        try{
            cmd.apply("test");
            fail("No parameter were given, the method should've crashed.");
        }catch(SyntaxException s){
            assertTrue(true);
        }
        
        if(line.equals(cmd.apply("test foo")))
            System.out.println("True");
        
        assertEquals(line, cmd.apply("test foo"));
        
    }
    
}
