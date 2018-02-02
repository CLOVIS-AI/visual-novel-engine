/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 * This class represents a stage.
 * @author CLOVIS
 */
public class Stage {
    
    private final String path;
    private String name;
    
    private boolean isLoaded;
    
    //private Collection<Line> lines
    
    public Stage(String path){
        this.path = path;
        isLoaded = false;
    }
    
    public void next(){
        
    }
    
    public void load(){
        
        isLoaded = true;
    }
    
    public void unload(){
        
        isLoaded = false;
    }
    
}
