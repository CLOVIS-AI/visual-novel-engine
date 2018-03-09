/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import junit.framework.TestCase;
import utils.resources.StringResource;
import vnscripts.content.Line;
import vnscripts.validator.Commands;
import vnscripts.validator.SyntaxException;

/**
 *
 * @author CLOVIS
 */
public class StageTest extends TestCase {
    
    public StageTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of load method, of class Stage.
     */
    public void testLoad() throws Exception {
        System.out.println("readHeader & getName");
        String name = "The name", 
               header = "STAGE|1|" + name,
               content = header + "\nout this is a test";
        StringResource tester = new StringResource("test", content);
        Stage t = new Stage(tester, Commands.DEFAULT);
        assertEquals(name, t.getName());
        
        try{
            Stage n = new Stage(new StringResource("test", "STAGE|1|N|D"), Commands.DEFAULT);
            fail("There was a wrong number of | in the message.");
        }catch(SyntaxException e){
            assertTrue(true);
        }
        
        try{
            Stage n = new Stage(new StringResource("test", "STAGE|2|Name"), Commands.DEFAULT);
            fail("Wrong version number");
        }catch(SyntaxException e){
            assertTrue(true);
        }
        
        try{
            Stage n = new Stage(new StringResource("test", "STAGE|1|"), Commands.DEFAULT);
            fail("No name provided.");
        }catch(SyntaxException e){
            assertTrue(true);
        }
        
        System.out.println("load");
        t.load();
    }
    
}
