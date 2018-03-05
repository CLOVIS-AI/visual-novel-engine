/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.validator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import vnscripts.content.parameters.Text;

/**
 * This class represents a set of commands. 
 * @author CLOVIS
 */
public class Commands {
    
    private Set<Command> commands;
    
    /**
     * Creates an empty set of commands.
     * @see HashSet#HashSet() More information
     */
    public Commands(){
        commands = new HashSet();
    }
    
    /**
     * Creates a set of commands based on a collection.
     * @param commands the commands
     * @see HashSet#HashSet(java.util.Collection) More information
     */
    public Commands(Collection<Command> commands){
        this.commands = new HashSet<>(commands);
    }
    
    /**
     * Adds a command to this set.
     * @param command the command to add
     * @see HashSet#add(java.lang.Object) More information
     */
    public void add(Command command){
        commands.add(command);
    }
    
    /**
     * Adds commands to this set.
     * @param command the commands to add
     * @see HashSet#addAll(java.util.Collection) More information
     */
    public void addAll(Collection<Command> command){
        commands.addAll(commands);
    }
    
    public static final Commands DEFAULT;
    
    static {
        DEFAULT = new Commands();
        
        // test -> print Test
        DEFAULT.add(new Command("test", (pr, pa) -> System.out.println("Test")));
        
        // out * -> stdout.print *
        DEFAULT.add(new Command("out", (pr, pa) -> System.out.println(pa.get(0)), Text.longFactory));
        
        // err * -> err.print *
        DEFAULT.add(new Command("err", (pr, pa) -> System.err.println(pa.get(0)), Text.longFactory));
    }
    
}
