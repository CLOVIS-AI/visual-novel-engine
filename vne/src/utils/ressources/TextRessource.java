/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ressources;

import java.io.IOException;
import utils.UnloadedException;
import vnscripts.validator.SyntaxException;

/**
 * This interface represents a text ressource (for instance a file on the
 * machine, or a remote file used with HTTPS, etc).
 * <p>This interface exists as a realization of the Bridge design pattern ; this
 * allows the program to work with any type of ressources instead of using
 * {@link java.io.File } for example.
 * @author CLOVIS
 */
public interface TextRessource extends Ressource {
    
    /**
     * Opens this ressource, so that {@link #readByte() } and {@link #readLine() }
     * might be used.
     */
    public void open();
    
    /**
     * Loads this object. Implementations of {@link Ressource} should override 
     * {@link #open() } instead of this method.
     */
    @Override
    public default void load() throws IOException, SyntaxException {
        open();
    }
    
    /**
     * Reads a byte from the ressource and returns it.
     * <p>This method should never return <code>null</code>, unless no new byte 
     * are available (ie. {@link #hasNext() hasNext()} returns <code>false</code>).
     * <p><b>Warning:</b> One should not call both {@link #readByte() } and
     * {@link #readLine() } in the same cycle, that is, if you used this method,
     * you should close this ressource and open it again before calling the other.
     * @return The next byte.
     * @throws UnloadedException if the ressource has not been openned.
     * @throws java.io.IOException if any IO exception occurs.
     * @throws IllegalStateException if two uncompatible methods are called.
     * @see #open() Open this ressource (before reading)
     * @see #close() Close this ressource
     */
    public byte readByte() throws UnloadedException, IOException, IllegalStateException;
    
    /**
     * Reads a line from the ressource and returns it.
     * <p>This method should never return <code>null</code>, unless no new line 
     * are available (ie. {@link #hasNext() hasNext()} returns <code>false</code>).
     * <p><b>Warning:</b> One should not call both {@link #readByte() } and
     * {@link #readLine() } in the same cycle, that is, if you used this method,
     * you should close this ressource and open it again before calling the other.
     * @return The next line.
     * @throws UnloadedException if the ressource has not been openned.
     * @throws java.io.IOException if any IO exception occurs.
     * @throws IllegalStateException if two uncompatible methods are called.
     * @see #open() Open this ressource (before reading)
     * @see #close() Close this ressource
     */
    public String readLine() throws UnloadedException, IOException, IllegalStateException;
    
    /**
     * Returns the number of the last read line (last call of {@link #readLine() }).
     * @return The number of the line
     * @throws UnloadedException If this ressource is not currently openned.
     * @see #open() Open/load this ressource
     */
    public int getLineNumber() throws UnloadedException;
    
    /**
     * Does this ressource contain any more bytes, that could be read with
     * {@link #readByte() }?
     * @return <code>true</code> if there are bytes remaining.
     */
    public boolean hasNext();
    
    /**
     * Closes this ressource, it cannot be read again.
     * This ressource might be reopened to give access to its content again.
     */
    public void close();
    
    /**
     * Is this ressource loaded?
     * @return <code>true</code> if this ressource is loaded.
     * @see #open() Load this ressource
     * @see #close() Unload this ressource
     */
    public boolean isLoaded();
    
}
