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
     * @param text
     * @throws SyntaxException 
     */
    public Text(String text){
        if(text == null || text.isEmpty())
            throw new SyntaxException("A text parameter cannot be null or empty : '" + text + "'");
        
        this.text = text;
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
     */
    public static final ParameterFactory factory = (String param) -> new Text(param);
    
}
