package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    
    // Class Fields
    private final static String DEFAULT_PATH = System.getProperty("user.home")
    + System.getProperty("file.separator")
    + "output.txt";
    private File file = new File(DEFAULT_PATH);

    // Class Constructor
    /**
     * Empty Constructor
     */
    public Controller() {
        /*
         * Put it just to avoid warnings
         */
    }

    // Class Method

    /**
     * A method for setting a File as current file
     * @param file contain the new current file to write in
     */
    public void setCurrentFile(File file) {
        this.file = file;
    }

    /**
     * A method for getting the current File
     * @return the current file
     */
    public File getCurrentFile() {
        return this.file;
    }

    /**
     * A method for getting the path (in form of String)
     * of the current File
     * @return the path in String form
     */
    public String getFilePath() {
        return file.getAbsolutePath();
    }

    /**
     * A method that gets a String as input and saves its content 
     * on the current file. This method may throw an IOException.
     * @param content contains what i want to add in the file
     */
    public void writeOnFile(String content) {
        try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)) {
            ps.println(content);
        } catch (final IOException e) {
            System.out.println("EXCEPTION GENERATED -> " 
            + e.getMessage()); //NOPMD
        }
    }
}
