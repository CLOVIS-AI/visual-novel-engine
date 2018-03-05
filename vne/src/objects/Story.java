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

/**
 * This class represents a story ; with characters, chapters, backgrounds and more.
 * @author CLOVIS
 */
public class Story implements Save, Load {
    
    private final Ressource directory;
    
    private final HashMap<String, Chapter> chapters
            = new HashMap<>();
    
    private final HashMap<String, Actor> actors
            = new HashMap<>();
    
    private Progress state = null;
    
    private Settings settings;
    
    private final Commands commands;
    
    /**
     * Creates a Story without loading it.
     * <p>When the story will be loaded, it will use the default set of commands
     * ({@link Commands#DEFAULT}).
     * @param story the directory of the story
     * @see #load() Load this story
     * @see #Story(utils.ressources.Ressource, vnscripts.validator.Commands) Choose your commands
     */
    public Story(Ressource story){
        this.directory = story;
        commands = Commands.DEFAULT;
    }
    
    /**
     * Creates a story without loading it.
     * <p>When the story will be loaded, it will use the provided set of
     * commands.
     * @param story the directory of the story
     * @param commands the set of commands you want to use
     * @see Use the default commands
     */
    public Story(Ressource story, Commands commands){
        this.directory = story;
        this.commands = commands;
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
    void loadChapters(){
        Ressource chaptersFolder = directory.child("chapters");
        
        for(Ressource chapter : chaptersFolder.children())
            chapters.put(chapter.name(), new Chapter(chapter));
    }

    /**
     * Loads all actors.
     * <p>The actors are expected to be located in the 'actors' directory inside
     * of the story's root. Files that are not directories are ignored.
     */
    void loadActors() {
        Ressource actorsFolder = directory.child("actors");
        
        for(Ressource actor : actorsFolder.children())
            actors.put(actor.name(), new Actor(actor));
    }

    /**
     * Loads the settings of this story.
     * <p>The settings are expected to be located in the 'settings.txt' file
     * inside of the story's root.
     */
    void loadSettings() {
        TextRessource settingsFile;
        try{
            settingsFile = (TextRessource) directory.child("settings.txt");
        }catch(ClassCastException e){
            throw new IllegalArgumentException("The /settings.txt ressource should be a text ressource.");
        }
        
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
