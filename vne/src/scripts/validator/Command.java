/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import objects.Progress;
import scripts.content.Line;
import scripts.content.Parameter;
import scripts.content.parameters.Text;

/**
 * Represents a scripting command along with its parameters.
 * @author CLOVIS
 */
public final class Command {
    
    private final String command;
    
    private final List<ParameterFactory> parameters; // ordonnated but not sorted
    
    private final BiConsumer<Progress, List<Parameter>> operation;
    
    private final boolean acceptText;
    
    /**
     * Creates a Command object.
     * @param command the command name (eg. "choose"...).
     * @param operation what this command should do.
     * @param parameters the parameters of this command.
     * @param acceptText <code>true</code> if this command accepts text.
     */
    public Command(String command, 
            BiConsumer<Progress, List<Parameter>> operation, 
            ArrayList<ParameterFactory> parameters,
            boolean acceptText){
        this.command = command;
        this.operation = operation;
        this.parameters = parameters;
        this.acceptText = acceptText;
    }
    
    /**
     * Creates a Command object.
     * @param command the command name (eg. "choose"...).
     * @param operation what this command should do.
     * @param parameters the parameters of this command.
     * @param acceptText <code>true</code> if this command accepts text.
     */
    public Command(String command,
            BiConsumer<Progress, List<Parameter>> operation,
            Collection<ParameterFactory> parameters,
            boolean acceptText){
        this(command, operation, new ArrayList<>(parameters), acceptText);
    }
    
    /**
     * Creates a Command object with only one parameter.
     * @param command the command name (eg. "choose"...).
     * @param operation what this command should do.
     * @param parameter the parameter of this command.
     * @param acceptText <code>true</code> if this command accepts text.
     */
    public Command(String command,
            BiConsumer<Progress, List<Parameter>> operation,
            ParameterFactory parameter,
            boolean acceptText){
        this(command, operation, new ArrayList<>(1), acceptText);
        parameters.add(parameter);
    }
    
    /**
     * Checks if a String validates this command. If it does, a Line object is
     * created.
     * @param line the text found.
     * @return A Line of the corresponding text and the corresponding parameters.
     * @throws SyntaxException if this text has a syntax error.
     * @throws IllegalArgumentException if the line does not correspond to this command.
     */
    public Line apply(String line) throws SyntaxException {
        
        assertCorrespondingCommand(line);
        
        String[] words = assertNumberOfParameters(line);
        
        String[] params = getParameters(words);
        
        List<Parameter> parameters = applyFactories(params);
        
        return new Line(operation, parameters);
    }
    
    /**
     * Asserts that the provided String corresponds to this command.
     * @param line the string
     */
    void assertCorrespondingCommand(String line){
        int firstSpace = line.indexOf(' ');
        
        if(firstSpace == -1){
            if(!line.equals(command)){
                throw new IllegalArgumentException("This command is called '" + command + "' but you provided the line : " + line);
            }
        }else{
            if(!line.substring(0, firstSpace).equals(command)){
                throw new IllegalArgumentException("This command is called '" + command + "' but you provided the line : " + line);
            }
        }
    }
    
    /**
     * Asserts that the expected number of parameters was provided.
     * @param line the text to verify
     * @return each word in the line
     * @throws SyntaxException the number of parameters was not the expected one.
     */
    String[] assertNumberOfParameters(String line){
        
        int parameterNumber = parameters.size() + (acceptText ? 1 : 0),
            wordNumber = parameterNumber + 1; // params + command name
        
        String[] words;
        
        try {
            if(acceptText)
                words = line.split(" ", wordNumber);
            else
                words = line.split(" ");
        }
        catch(StringIndexOutOfBoundsException e) { 
            throw new SyntaxException("Not enough parameters were provided; " + 
                    parameterNumber + " were expected.\nLine : " + line); 
        }
        
        if(words.length != wordNumber)
            throw new SyntaxException("Expected " + parameterNumber + " parameters, found " + (words.length-1) + ".\nLine : " + line);
        
        return words;
    }
    
    /**
     * Removes the command name from the words.
     * <p>This method doesn't check that the accurate command name is provided,
     * because this should have already been verified by {@link #assertCorrespondingCommand(java.lang.String) assertCorrespondingCommand}.
     * It only deletes the first element of the array.
     * @param words the words of a line, as returned by {@link #assertNumberOfParameters(java.lang.String) assertNumberOfParameters}.
     * @return The same array, without the command name.
     */
    String[] getParameters(String[] words){
        String[] params = new String[words.length-1];
        
        for(int i = 1; i < words.length; i++)
            params[i-1] = words[i];
        
        return params;
    }
    
    /**
     * Applies every factory to the corresponding String found.
     * @param params the parameters found, as provided by {@link #getParameters(java.lang.String[]) getParameters}.
     * @return A lit of all the parameters.
     * @throws SyntaxException if any factory fails.
     */
    List<Parameter> applyFactories(String[] params){
        List<Parameter> parameters = new ArrayList<>(params.length);
        
        for(int i = 0; i < params.length; i++){
            String param = params[i];
            ParameterFactory factory = this.parameters.get(i);
            parameters.add(factory.apply(param));
        }
        
        return parameters;
    }
    
}
