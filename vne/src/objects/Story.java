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
    
    private final File directory;
    
    private final HashMap<String, Chapter> chapters
            = new HashMap<>();
    
    private final HashMap<String, Actor> actors
            = new HashMap<>();
    
    private Progress state = null;
    
    private Settings settings;
    
    public Story(File folder){
        this.directory = folder;
    }
    
    /**
     * Loads this story at the last save. Any unsaved progress will be lost.
     */
    public void load(){
        reload();
    }
    
    /**
     * Loads the contents of the story without modifying the story's progress.
     */
    public void reload(){
        loadSettings();
        loadChapters();
        loadActors();
    }
    
    /**
     * Loads all chapters into memory.
     * <p>The chapters will be located in the 'chapters' directory inside of the
     * story's root. Files that are not directories are ignored.
     */
    private void loadChapters(){
        File chaptersFolder = new File(directory, "chapters");
        
        for(File chapter : chaptersFolder.listFiles(f -> f.isDirectory()))
            chapters.put(chapter.getName(), new Chapter(chapter));
    }

    private void loadActors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadSettings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
