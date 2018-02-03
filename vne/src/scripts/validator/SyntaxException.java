/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.validator;

/**
 *
 * @author ivan
 */
public class SyntaxException extends RuntimeException {

    /**
     * Creates a new instance of <code>SyntaxException</code> without detail
     * message.
     */
    public SyntaxException() {
        super();
    }
    
    /**
     * Constructs an instance of <code>SyntaxException</code>.
     * @param msg the detail message.
     */
    public SyntaxException(String msg){
        super(msg);
    }

    /**
     * Constructs an instance of <code>SyntaxException</code> with the specified
     * detail message.
     *
     * @param file the file where the syntax error occured.
     * @param msg the detail message.
     */
    public SyntaxException(String file, String msg) {
        super(file + " -> " + msg);
    }
}
