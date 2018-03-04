/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ressources;

import java.io.IOException;
import java.util.Set;
import objects.Load;
import utils.UnloadedException;

/**
 * This interface represents a text-ressource (for instance a file on the
 * machine, or a remote file used with HTTPS, etc).
 * <p>This interface exists as a realization of the Bridge design pattern ; this
 * allows the program to work with any type of ressources instead of using
 * {@link java.io.File } for example.
 * @author CLOVIS
 */
public interface Ressource extends Load {
    
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
    public default void load(){
        open();
    }
    
    /**
     * Reads a byte from the ressource and returns it.
     * <p>This method should never return <code>null</code>, unless no new byte 
     * are available (ie. {@link #hasNext() hasNext()} returns <code>false</code>).
     * @return The next byte.
     * @throws UnloadedException if the ressource has not been openned.
     * @throws java.io.IOException if any IO exception occurs.
     * @see #open() Open this ressource (before reading)
     * @see #close() Close this ressource
     */
    public byte readByte() throws UnloadedException, IOException;
    
    /**
     * Reads a line from the ressource and returns it.
     * <p>This method should never return <code>null</code>, unless no new line 
     * are available (ie. {@link #hasNext() hasNext()} returns <code>false</code>).
     * @return The next line.
     * @throws UnloadedException if the ressource has not been openned.
     * @throws java.io.IOException if any IO exception occurs.
     * @see #open() Open this ressource (before reading)
     * @see #close() Close this ressource
     */
    public String readLine() throws UnloadedException, IOException;
    
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
    
    /**
     * Gets every children of this ressource (not recursively).
     * @return Every children of this ressource.
     */
    public Set<Ressource> children();
    
    /**
     * Gets the parent ressource.
     * @return The parent ressource.
     */
    public Ressource parent();
    
    /**
     * Get a specific child.
     * @param name the name of the child
     * @return The child that is named accordingly.
     */
    public Ressource child(String name);
    
}
