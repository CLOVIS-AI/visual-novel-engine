/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
    
}
