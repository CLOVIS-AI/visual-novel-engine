/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.content;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import objects.Progress;

/**
 * 
 * @author CLOVIS
 */
public class Line {
   
    private final List<Parameter> parameters;
    
    private final BiConsumer<Progress, List<Parameter>> operation;
    
    public Line(BiConsumer<Progress, List<Parameter>> operation, 
            ArrayList<Parameter> parameters){
        this.operation = operation;
        this.parameters = parameters;
    }
    
    public Line(BiConsumer<Progress, List<Parameter>> operation, 
            Collection<Parameter> parameters){
        this(operation, new ArrayList<>(parameters));
    }
    
    public Line(BiConsumer<Progress, List<Parameter>> operation, 
            Parameter parameter){
        this(operation, new ArrayList<>(1));
        parameters.add(parameter);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.parameters);
        hash = 97 * hash + Objects.hashCode(this.operation);
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
        final Line other = (Line) obj;
        if (!this.parameters.equals(other.parameters)) {
            return false;
        }
        if (!Objects.equals(this.operation, other.operation)) {
            return false;
        }
        return true;
    }
    
}
