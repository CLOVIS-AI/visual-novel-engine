/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import utils.ressources.TextRessource;

/**
 * The settings of a particular story.
 * @author CLOVIS
 */
class Settings implements Save {
    
    private final TextRessource file;

    /**
     * Loads the settings from a file.
     * @param file the file.
     */
    Settings(TextRessource file) {
        this.file = file;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
