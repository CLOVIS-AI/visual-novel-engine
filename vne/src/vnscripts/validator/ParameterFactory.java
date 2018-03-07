/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.validator;

import vnscripts.content.Parameter;

/**
 * The aim of this interface is to check that a parameter given to a command is
 * valid (can be recognized and is legal).
 * <p>The implementation should check that :
 * <ol>
 *      <li>The parameter is legal (not null).</li>
 *      <li>The parameter is of the appropriate type.</li>
 * </ol>
 * <p>Note that a parameter <b>can</b> contain space characters, however this is
 * not allowed except for the trailing text. In any other case, be aware of it
 * and remember you should throw a {@link SyntaxException } if one is present.
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
