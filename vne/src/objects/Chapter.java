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
 *
 * @author CLOVIS
 */
public class Chapter implements Save {
    
    private final File directory;
    
    private final HashMap<String, Stage> stages
            = new HashMap<>();

    /**
     * Creates this chapter and searches for stages but doesn't load them.
     * @param chapter the directory where this chapter is.
     */
    public Chapter(File chapter) {
        FileUtility.assertDirectory(chapter);
        directory = chapter;
        loadStages();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    final void loadStages(){
        if(!stages.isEmpty())
            throw new IllegalStateException("This method should only called when the chapter is loaded, that is, only once.");
        for(File stage : directory.listFiles(FileUtility.directories))
            stages.put(stage.getName(), new Stage(stage));
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
