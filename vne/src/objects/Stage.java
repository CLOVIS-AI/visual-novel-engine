/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import utils.ressources.TextRessource;
import vnscripts.content.Line;
import vnscripts.validator.Commands;
import vnscripts.validator.SyntaxException;

/**
 * This class represents a stage.
 * @author CLOVIS
 */
public class Stage implements Save, Load {
    
    private final TextRessource ressource;
    private final String name;
    
    private boolean isLoaded;
    
    /** The set of commands used when loading. */
    private final Commands commands;
    
    private List<Line> lines;
    
    /**
     * Creates a Stage object.
     * <p>The first line of the path is read to get the stage name, however any
     * other data is not read, therefore the object does not contain any 
     * information on the actual content of the file yet. Use {@link #load() }
     * to load the stage.
     * @param ressource Location of the Stage save file.
     */
    public Stage(TextRessource ressource, Commands commands) throws SyntaxException{
        this.ressource = ressource;
        isLoaded = false;
        name = readHeader(ressource);
        this.commands = commands;
    }
    
    private static String readHeader(TextRessource ressource) throws SyntaxException{
        try {
            ressource.open();
            String header = ressource.readLine();
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
        } catch (IOException ex) {
            throw new IllegalArgumentException("The ressource " + ressource.toString() + " cannot be opened: (" + ex.toString() + ")");
        }finally{
            ressource.close();
        }
    }
    
    @Override
    public void load() throws IOException, SyntaxException {
        isLoaded = true;
        
        lines = new ArrayList<>();
        
        ressource.open();
        while(ressource.hasNext()){
            String text = ressource.readLine();
            
            Line line;
            try{
                line = commands.validate(text);
            }catch(SyntaxException e){
                throw new SyntaxException(ressource, ressource.getLineNumber(), e);
            }
            
            lines.add(line);
        }
        ressource.close();
    }
    
    public void unload(){
        isLoaded = false;
        lines = null;
        System.gc();
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
