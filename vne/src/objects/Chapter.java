/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author CLOVIS
 */
class Chapter {
    
    private final File directory;
    
    private final HashMap<String, Stage> stages
            = new HashMap<>();

    /**
     * Creates this chapter and searches for stages but doesn't load them.
     * @param chapter the directory where this chapter is.
     */
    public Chapter(File chapter) {
        directory = chapter;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
