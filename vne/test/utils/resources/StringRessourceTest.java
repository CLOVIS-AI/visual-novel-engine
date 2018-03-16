/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.resources;

import junit.framework.TestCase;

/**
 *
 * @author CLOVIS
 */
public class StringRessourceTest extends TestCase {
    
    private static String testerText = "THIS\nIS\nJUST\nA TEST";
    private static StringResource tester = new StringResource("tester", testerText);
    
    public StringRessourceTest(String testName) {
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
     * Test of readByte method, of class StringResource.
     */
    public void testReadByte() throws Exception {
        System.out.println("readByte");
        tester.open();
        
        for(char c : testerText.toCharArray())
            assertEquals(c, tester.readByte());
        
        tester.close();
    }

    /**
     * Test of readLine method, of class StringResource.
     */
    public void testReadLine() throws Exception {
        System.out.println("readLine");
        tester.open();
        
        for(String c : testerText.split(System.lineSeparator()))
            assertEquals(c, tester.readLine());
        
        tester.close();
    }
    
}
