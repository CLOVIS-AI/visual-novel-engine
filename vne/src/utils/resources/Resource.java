/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.resources;

import java.util.Set;
import objects.Load;

/**
 * This interface represents a resource (for instance a file on the
 * machine, or a remote file used with HTTPS, etc).
 * <p>This interface exists as a realization of the Bridge design pattern ; this
 * allows the program to work with any type of resources instead of using
 * {@link java.io.File } for example.
 * @author CLOVIS
 */
public interface Resource extends Load {
    
    /**
     * Gets every getChildren of this resource (not recursively).
     * @return Every children of this resource. If there are no children, 
     * returns an empty set.
     */
    public Set<Resource> getChildren();
    
    /**
     * Get a specific getChild.
     * @param name the name of the getChild
     * @return The child that is named accordingly. If there is no child named 
     * this way, returns <code>null</code>.
     */
    public Resource getChild(String name);
    
    /**
     * Returns the name of this resource (ie. for files, the name of the file).
     * @return The name of the resource.
     */
    public String getName();
    
}
