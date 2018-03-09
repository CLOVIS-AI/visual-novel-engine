/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnscripts.content.parameters;

import objects.Chapter;
import objects.Story;
import vnscripts.content.Parameter;
import vnscripts.validator.ParameterFactory;
import vnscripts.validator.SyntaxException;

/**
 * Represents a link to a Chapter (useful in choices for exemple).
 * @author CLOVIS
 */
public class ChapterLink implements Parameter {
    
    private final String link;
    
    private Chapter chapter;
    
    public ChapterLink(String parameter) throws SyntaxException{
        if(parameter == null || parameter.equals(""))
            throw new SyntaxException("The link of a chapter should not be null.");
        
        link = parameter;
    }
    
    @Override
    public void link(Story story){
        chapter = story.getChapter(link);
    }

    @Override
    public String getAsString() {
        return "chp:" + link;
    }
    
    /**
     * Implementation of the {@link ParameterFactory} interface, used to create
     * a ChapterLink parameter when appropriate.
     */
    public static final ParameterFactory factory = (String param) -> {
            String[] params = param.split(":");
            if(params[0].equals("chapter") ||
                    params[0].equals("chp") ||
                    params[0].equals("chapt"))
                return new ChapterLink(params[2]);
            else
                return null;
        };
    
}
