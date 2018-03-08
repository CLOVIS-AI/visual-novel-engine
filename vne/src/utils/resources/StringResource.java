/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.resources;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import utils.UnloadedException;

/**
 * A ressource that is based on a String.
 * @author CLOVIS
 */
public final class StringResource implements TextResource {

    private final String name;
    
    private final String content;
    private String[] lines;
    private int position;
    
    private boolean isLoaded;
    private boolean isReadingWithByte,
                    isReadingWithLine;
    
    /**
     * Creates a ressource based on a String (mostly used for Unit Testing).
     * @param name the name of this ressource
     * @param content the content of the ressource
     */
    public StringResource(String name, String content){
        this.content = content;
        close();
        this.name = name;
    }
    
    @Override
    public void open() {
        isLoaded = true;
    }

    @Override
    public byte readByte() throws UnloadedException, IOException {
        isReadingWithByte = true;
        if(isReadingWithLine)
            throw new IllegalStateException("You cannot read with both "
                    + "readByte and readLine!");
        return (byte) content.charAt(position++);
    }

    @Override
    public String readLine() throws UnloadedException, IOException {
        isReadingWithLine = true;
        if(isReadingWithByte)
            throw new IllegalStateException("You cannot read with both "
                    + "readByte and readLine!");
        if(lines == null)
            lines = content.split(System.lineSeparator());
        return lines[position++];
    }
    
    @Override
    public int getLineNumber() throws UnloadedException {
        return position;
    }

    @Override
    public boolean hasNext() {
        return position < content.length()-1;
    }

    @Override
    public void close() {
        isLoaded = false;
        position = 0;
        isReadingWithByte = false;
        isReadingWithLine = false;
        lines = null;
    }

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public Set<Resource> getChildren() {
        return new HashSet<>();
    }

    @Override
    public Resource getChild(String name) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
