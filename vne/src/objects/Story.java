/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.util.HashMap;
import utils.FileUtility;

/**
 * This class represents a story ; with characters, chapters, backgrounds and more.
 * @author CLOVIS
 */
public class Story implements Save, Load {
    
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
    @Override
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
     * Loads all chapters.
     * <p>The chapters will be located in the 'chapters' directory inside of the
     * story's root. Files that are not directories are ignored.
     */
    private void loadChapters(){
        File chaptersFolder = new File(directory, "chapters");
        FileUtility.assertDirectory(chaptersFolder);
        
        for(File chapter : chaptersFolder.listFiles(FileUtility.directories))
            chapters.put(chapter.getName(), new Chapter(chapter));
    }

    /**
     * Loads all actors.
     * <p>The actors are expected to be located in the 'actors' directory inside
     * of the story's root. Files that are not directories are ignored.
     */
    private void loadActors() {
        File actorsFolder = new File(directory, "actors");
        FileUtility.assertDirectory(actorsFolder);
        
        for(File actor : actorsFolder.listFiles(FileUtility.directories))
            actors.put(actor.getName(), new Actor(actor));
    }

    /**
     * Loads the settings of this story.
     * <p>The settings are expected to be located in the 'settings.txt' file
     * inside of the story's root.
     */
    private void loadSettings() {
        File settingsFile = new File(directory, "settings.txt");
        FileUtility.assertFile(settingsFile);
        
        settings = new Settings(settingsFile);
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Gets a Chapter object.
     * @param name name of the chapter
     * @return The Chapter object.
     * @throws NullPointerException if no chapter with this name exist.
     */
    public Chapter getChapter(String name){
        if(chapters.containsKey(name))
            return chapters.get(name);
        else
            throw new NullPointerException("No chapter named '" + name + "' has been found.");
    }
}
