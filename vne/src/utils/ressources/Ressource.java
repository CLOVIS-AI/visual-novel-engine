/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ressources;

import java.util.Set;
import objects.Load;

/**
 * This interface represents a ressource (for instance a file on the
 * machine, or a remote file used with HTTPS, etc).
 * <p>This interface exists as a realization of the Bridge design pattern ; this
 * allows the program to work with any type of ressources instead of using
 * {@link java.io.File } for example.
 * @author CLOVIS
 */
public interface Ressource extends Load {
    
    /**
     * Gets every children of this ressource (not recursively).
     * @return Every children of this ressource. If there are no children,
     * returns an empty set.
     */
    public Set<Ressource> children();
    
    /**
     * Get a specific child.
     * @param name the name of the child
     * @return The child that is named accordingly. If there is no child named
     * this way, returns <code>null</code>.
     */
    public Ressource child(String name);
    
    /**
     * Returns the name of this ressource (ie. for files, the name of the file).
     * @return The name of the ressource.
     */
    public String name();
    
}
