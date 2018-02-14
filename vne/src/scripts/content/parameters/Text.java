/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.content.parameters;

import java.util.Objects;
import scripts.content.Parameter;
import scripts.validator.ParameterFactory;
import scripts.validator.SyntaxException;

/**
 * This parameter represents text. This class is immutable.
 * @author CLOVIS
 */
public class Text implements Parameter {
    
    /**
     * The text of this parameter.
     */
    private final String text;
    
    /**
     * Creates a Text parameter.
     * @param text the text that was given
     * @param allowSpaces does this parameter allow spaces?
     * @throws SyntaxException if any syntax rule of VNScript is not verified.
     */
    public Text(String text, boolean allowSpaces){
        if(text == null || text.isEmpty())
            throw new SyntaxException("A text parameter cannot be null or empty : '" + text + "'");
        
        if(!allowSpaces && text.contains(" "))
            throw new SyntaxException("Unexpected space character found : '" + text + "'");
        
        this.text = text;
    }
    
    /**
     * Creates a Text parameter that does not allow space characters.
     * @param text the text that was given
     * @throws SyntaxException if any syntax rule of VNScript is not verified.
     */
    public Text(String text){
        this(text, false);
    }
    
    @Override
    public String getAsString() {
        return text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.text);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Text other = (Text) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        return true;
    }
    
    /**
     * Implementation of the {@link ParameterFactory} interface, used to create
     * a Text parameter when appropriate.
     * <p>This implementation does not allow space characters, which means it
     * should be used only for text that is not trailing.
     */
    public static final ParameterFactory shortFactory = (String param) -> new Text(param, false);
    
    /**
     * Implementation of the {@link ParameterFactory} interface, used to create
     * a Text parameter when appropriate.
     * <p>This implementation allows space characters, which means it
     * should be used only for trailing text.
     */
    public static final ParameterFactory longFactory = (String param) -> new Text(param, true);
    
}
