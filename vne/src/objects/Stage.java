/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import scripts.content.Line;

/**
 * This class represents a stage.
 * @author CLOVIS
 */
public class Stage implements Save, Load {
    
    private final String path;
    private String name;
    
    private boolean isLoaded;
    
    private final List<Line> lines
            = new ArrayList<>();
    
    /**
     * Creates a Stage object corresponding to a Stage, but does not load it yet.
     * @param file the location of the file.
     * @see #load() Load this stage
     */
    public Stage(File file){
        this(file.getAbsolutePath());
    }
    
    /**
     * Creates a Stage object corresponding to a Stage, but does not load it yet.
     * @param path the location of the file.
     * @see #load() Load this stage
     */
    public Stage(String path){
        this.path = path;
        isLoaded = false;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
