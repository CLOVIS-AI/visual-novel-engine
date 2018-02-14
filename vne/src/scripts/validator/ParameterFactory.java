/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.validator;

import scripts.content.Parameter;

/**
 * The aim of this interface is to check that a parameter given to a command is
 * valid (can be recognized and is legal).
 * <p>The implementation should check that :
 * <ol>
 *      <li>The parameter is legal (not null).</li>
 *      <li>The parameter is of the appropriate type.</li>
 * </ol>
 * @author CLOVIS
 */
@FunctionalInterface
public interface ParameterFactory {
    
    /**
     * Creates the parameter of a Command.
     * @param param the expected parameter.
     * @return The corresponding Parameter object, only if it is appropriate, null
     * otherwise.
     * @throws SyntaxException if this argument is not legal.
     */
    public Parameter apply(String param)
            throws SyntaxException;
}
