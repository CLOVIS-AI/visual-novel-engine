/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

/**
 *
 * @author CLOVIS
 */
public abstract class Command {
    
    private final String name;
    
    private Argument[] args;
    
    public Command(String name){
        this.name = name;
    }
    
    public void act(){
        
    }
    
}
