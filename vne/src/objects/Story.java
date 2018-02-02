/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.util.HashMap;

/**
 * This class represents a story ; with characters, chapters, backgrounds and more.
 * @author CLOVIS
 */
public class Story {
    
    private final File folder;
    
    private final HashMap<String, Chapter> chapters
            = new HashMap<>();
    
    private final HashMap<String, Actor> actors
            = new HashMap<>();
    
    public Story(File folder){
        this.folder = folder;
    }
    
    public void load(){
        
    }
    
    /**
     * The current state of the game : what is displayed, etc.
     */
    private class State {
        
    }
}
