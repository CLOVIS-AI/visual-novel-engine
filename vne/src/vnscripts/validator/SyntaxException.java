/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.validator;

import utils.resources.TextResource;

/**
 * An exception thrown when the script is not well-written.
 * @author CLOVIS
 */
public class SyntaxException extends Exception {

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
     * @param line the line where the exception occurred
     * @param msg the detail message.
     */
    public SyntaxException(TextResource file, int line, String msg) {
        super(file + ":" + line + " -> " + msg);
    }
    
    /**
     * Constructs an instance of <code>SyntaxException</code> with the specified
     * detail message.
     *
     * @param file the file where the syntax error occured.
     * @param line the line where the exception occurred
     * @param msg the detail message.
     */
    public SyntaxException(TextResource file, int line, SyntaxException msg) {
        super(file + ":" + line + " -> " + msg.getMessage());
    }
}
