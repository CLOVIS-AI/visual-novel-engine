/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileFilter;

/**
 * Utility class to deal with files and directories.
 * @author CLOVIS
 */
public class FileUtility {
    
    /**
     * Filter meant to be used in {@link java.io.File#listFiles(java.io.FileFilter) File.listFiles}
     * to select directories only.
     */
    public static final FileFilter directories = f -> f.isDirectory();
    
    /**
     * Checks whether a file is a directory. If it's not, an {@link IllegalArgumentException} is thrown.
     * @param file the file to be checked.
     * @throws NullPointerException if the file is not a directory.
     */
    public static void assertDirectory(File file){
        assertNotNull(file);
        assertExists(file);
        
        if(!file.isDirectory())
            throw new NullPointerException("The file is not a directory : " + file.getAbsolutePath());
        
        assertReadable(file);
    }
    
    /**
     * Checks whether a file is not a directory. If it's not, an {@link IllegalArgumentException} is thrown.
     * @param file the file to be checked.
     * @throws NullPointerException if the file is a directory.
     */
    public static void assertFile(File file){
        assertNotNull(file);
        assertExists(file);
        
        if(!file.isFile())
            throw new NullPointerException("The file is a directory : " + file.getAbsolutePath());
        
        assertReadable(file);
    }
    
    /**
     * Checks whether a file is null.
     * @param file the file to be checked.
     */
    private static void assertNotNull(File file){
        if(file == null)
            throw new IllegalArgumentException("The file should not be 'null'.");
    }
    
    /**
     * Checks whether a file or directory exists.
     * @param file the file to be checked.
     */
    private static void assertExists(File file){
        if(!file.exists())
            throw new NullPointerException("The directory doesn't exist : " + file.getAbsolutePath());
    }
    
    /**
     * Checks whether a file or directory is readable.
     * @param file the file to be checked.
     */
    private static void assertReadable(File file){
        if(!file.canRead())
            throw new NullPointerException("The directory cannot be read : " + file.getAbsolutePath());
    }
    
}
