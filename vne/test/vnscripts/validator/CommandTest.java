/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.validator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import objects.Progress;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vnscripts.content.Line;
import vnscripts.content.Parameter;
import vnscripts.content.parameters.Number;
import vnscripts.content.parameters.Text;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author CLOVIS
 */
public class CommandTest {
    
    /** Parameters : Number, Text */
    public static final List<ParameterFactory> params01 = Arrays.asList(
            Number.factory,
            Text.shortFactory
        );
    
    /** Parameters : Number, ChapterLink, Text */
    public static final List<ParameterFactory> params02 = Arrays.asList(
            Number.factory,
            Text.shortFactory,
            Text.longFactory
        );
    
    /** A prewritten command for test purposes : 'test'. Parameters : Number, Text */
    public static final Command command01f = new Command("test", (pr, pm) -> System.out.println("Test"), params01);
    /** A prewritten command for test purposes : 'test'. Parameters : Number, Text + Text */
    public static final Command command01t = new Command("test", (pr, pm) -> System.out.println("Test"), params02);
    
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
        Command cmd = new Command("test", action, Text.shortFactory);
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
        
        assertEquals(line, cmd.apply("test foo"));
        
    }

    /**
     * Test of assertCorrespondingCommand method, of class Command.
     */
    @Test
    public void testAssertCorrespondingCommand() {
        System.out.println("assertCorrespondingCommand");
        
        try{
            command01f.assertCorrespondingCommand("test 01");
            assertTrue(true);
        }catch(IllegalArgumentException e){
            fail("The command 'test' was corresponding.");
        }
        
        try{
            command01f.assertCorrespondingCommand("tast 01");
            fail("The command 'tast' was not corresponding.");
        }catch(IllegalArgumentException e){
            assertTrue(true);
        }
    }

    /**
     * Test of assertNumberOfParameters method, of class Command.
     */
    @Test
    public void testAssertNumberOfParameters() {
        System.out.println("assertNumberOfParameters");
        
        // Tests for commands that do not accept text as a last argument
        
        String[] reply = command01f.assertNumberOfParameters("test 2 foo");
        assertEquals(3, reply.length);
        assertArrayEquals(new String[]{"test", "2", "foo"}, reply);
        
        // Tests for commands that do accept text as a last argument
        
        String[] reply3 = command01t.assertNumberOfParameters("test 2 foo bar foo bar");
        assertEquals(4, reply3.length);
        assertArrayEquals(new String[]{"test", "2", "foo", "bar foo bar"}, reply3);
        
        try{
            String[] reply4 = command01t.assertNumberOfParameters("test 2 foo");
            fail("The number of parameters was not the expected value, found "
                    + Arrays.deepToString(reply4));
        }catch(SyntaxException e){
            assertTrue(true);
        }
    }

    /**
     * Test of getParameters method, of class Command.
     */
    @Test
    public void testGetParameters() {
        System.out.println("getParameters");
        
        // Because this method is stateless, it doesn't matter which command we
        // call it upon.
        
        String[] words = {"test", "foo", "bar"};
        assertArrayEquals(new String[]{"foo", "bar"}, command01f.getParameters(words));
        
        String[] words2 = {"test"};
        assertArrayEquals(new String[0], command01f.getParameters(words2));
    }

    /**
     * Test of applyFactories method, of class Command.
     */
    @Test
    public void testApplyFactories() {
        System.out.println("applyFactories");
        
        // Commands that do not accept trailing text
        
        List<Parameter> params = command01f.applyFactories(new String[]{"2", "foo"});
        assertEquals(new Number("2"), params.get(0));
        assertEquals(new Text("foo"), params.get(1));
        
        // Commands that do accept trailing text
        
        /*List<Parameter> params2 = command01t.applyFactories(new String[]{"2", "foo", "bar foo bar"});
        params2.forEach(p -> System.out.println("Found : " + p.getAsString()));
        assertEquals(new Number("2"), params2.get(0));
        assertEquals(new Text("foo"), params2.get(1));
        assertEquals(new Text("bar foo bar"), params2.get(2));*/
    }
    
}
