/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;
import vnscripts.validator.SyntaxException;

/**
 * States that this object can be loaded.
 * @author CLOVIS
 */
public interface Load {
    
    /**
     * Loads this object.
     * @throws java.io.IOException If something goes wrong during the loading.
     * @throws vnscripts.validator.SyntaxException If the object cannot be read.
     */
    public void load() throws IOException, SyntaxException;
    
}
