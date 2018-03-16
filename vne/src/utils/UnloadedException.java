/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 * Use this exception when unloaded resources are accessed.
 * @author CLOVIS
 */
public class UnloadedException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>UnloadedException</code> without detail
     * message.
     */
    public UnloadedException() {
    }

    /**
     * Constructs an instance of <code>UnloadedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnloadedException(String msg) {
        super(msg);
    }
}
