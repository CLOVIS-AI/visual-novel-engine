/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.content.parameters;

import vnscripts.content.Parameter;
import vnscripts.validator.ParameterFactory;

/**
 * This parameter represents a number (integer). This class is immutable.
 * @author CLOVIS
 */
public class Number implements Parameter {
    
    private final long value;
    
    /**
     * Instantiates a Number parameter.
     * @param value the value it holds.
     */
    public Number(long value){
        this.value = value;
    }
    
    /**
     * Instantiates a Number parameter.
     * @param value the value it holds.
     */
    public Number(int value){
        this((long) value);
    }
    
    /**
     * Instantiates a Number parameter.
     * @param value the value it holds.
     */
    public Number(short value){
        this((long) value);
    }
    
    /**
     * Instantiates a Number parameter.
     * @param value the value it holds.
     */
    public Number(byte value){
        this((long) value);
    }
    
    /**
     * Instantiates a Number parameter.
     * @param value the value it holds.
     */
    public Number(String value){
        this(Long.valueOf(value));
    }

    @Override
    public String getAsString() {
        return "" + value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.value ^ (this.value >>> 32));
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
        final Number other = (Number) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }
    
    /**
     * Implementation of the {@link ParameterFactory} interface, used to create
     * a Number parameter when appropriate.
     */
    public static final ParameterFactory factory = (String param) -> new Number(param);
}
