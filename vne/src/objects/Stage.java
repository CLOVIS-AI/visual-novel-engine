/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import vnscripts.content.Line;
import vnscripts.content.parameters.Text;
import vnscripts.validator.Command;
import vnscripts.validator.SyntaxException;

/**
 * This class represents a stage.
 * @author CLOVIS
 */
public class Stage implements Save, Load {
    
    private final String path;
    private final String name;
    
    private boolean isLoaded;
    
    private List<Line> lines;
    
    /**
     * Creates a Stage object.
     * <p>The first line of the path is read to get the stage name, however any
     * other data is not read, therefore the object does not contain any 
     * information on the actual content of the file yet. Use {@link #load() }
     * to load the stage.
     * @param path Location of the Stage save file.
     */
    public Stage(String path){
        this.path = path;
        isLoaded = false;
        name = readHeader(path);
    }
    
    private String readHeader(String path){
        try {
            String header = new BufferedReader(new FileReader(path)).readLine();
            String[] parts = header.split("|");
            
            if(parts.length != 3)
                throw new SyntaxException("The header should be a compound of "
                        + "the file declaration, the version and the name. "
                        + "You provided " + parts.length + ": " + parts);
            
            if(!parts[0].equalsIgnoreCase("STAGE"))
                throw new SyntaxException("Expected a STAGE file, found "
                        + parts[0] + " in the header.");
            
            if(!parts[1].equalsIgnoreCase("1"))
                throw new SyntaxException("Only the file version 1 is supported,"
                        + " the header says " + parts[1]);
            
            if(parts[2].equals(""))
                throw new SyntaxException("You have to provide the name of the "
                        + "Stage in the header, found: " + parts[2]);
            
            return parts[2];
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("The file " + path + " cannot be found: (" + ex.toString() + ")");
        } catch (IOException ex) {
            throw new IllegalArgumentException("The file " + path + " cannot be opened: (" + ex.toString() + ")");
        }
    }
    
    public void next(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void load(){
        isLoaded = true;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void unload(){
        isLoaded = false;
        lines.clear();
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // ************************************************************************* S T A T I C
    
    private static final Set<Command> commands;
    
    static {
        System.out.print("Loading commands ... ");
        commands = new HashSet();
        commands.add(new Command("sout", (p, params) -> System.out.println(((Text)params.get(0)).getAsString()), Text.longFactory));
        commands.add(new Command("warn", (p, params) -> System.err.println(((Text)params.get(0)).getAsString()), Text.longFactory));
        System.out.println("Done.");
    }
    
}
