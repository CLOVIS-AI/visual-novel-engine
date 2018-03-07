/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.HashMap;
import utils.ressources.Ressource;
import utils.ressources.TextRessource;
import vnscripts.validator.Commands;
import vnscripts.validator.SyntaxException;

/**
 *
 * @author CLOVIS
 */
public class Chapter implements Save {
    
    private final Ressource directory;
    
    private final HashMap<String, Stage> stages
            = new HashMap<>();
    
    private final Commands commands;

    /**
     * Creates this chapter and searches for stages but doesn't load them.
     * @param chapter the directory where this chapter is.
     */
    public Chapter(Ressource chapter, Commands commands) throws SyntaxException {
        directory = chapter;
        this.commands = commands;
        loadStages();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    final void loadStages() throws SyntaxException{
        if(!stages.isEmpty())
            throw new IllegalStateException("This method should only called when the chapter is loaded, that is, only once.");
        for(Ressource stage : directory.getChildren())
            stages.put(stage.getName(), new Stage((TextRessource)stage, commands));
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
