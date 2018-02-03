/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.content;

import objects.Story;

/**
 * Represents a parameter of a command.
 * <p>Any implementation of this interface should be immutable.
 * @author CLOVIS
 */
public interface Parameter {
    
    /**
     * Gets this parameter's representation as a String, as it would be written
     * in a script file.
     * @return This parameter's representation.
     */
    public String getAsString();
    
    /**
     * Links this parameter with any ressource it may need.
     * <p>Exemples of use :
     * <ul>
     *      <li>The image path in the "background" command</il>
     *      <li>The chapter of a "choose" command</li>
     * </ul>
     * <p>The default implementation 
     * @param story 
     */
    public default void link(Story story){}
    
}
