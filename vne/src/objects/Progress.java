/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 * The current state of the story.
 * @author CLOVIS
 */
public class Progress {
    
    private Chapter currentChapter;
    
    private Stage currentStage;
    
    /**
     * Gives access to this class' content in a read-only manner.
     */
    public final ProgressGetters get = new ProgressGetters();
    
    /**
     * Contains the getters of Progress. They are kept in a separate class than
     * the main methods because it's often needed to provide read-only access to
     * this class.
     */
    private class ProgressGetters {
        
        /**
         * Gets the current chapter.
         * @return The current chapter.
         */
        public Chapter getCurrentChapter(){
            return currentChapter;
        }
        
        /**
         * Gets the current stage.
         * @return The current stage.
         */
        public Stage getCurrentStage(){
            return currentStage;
        }
        
    }
    
}
