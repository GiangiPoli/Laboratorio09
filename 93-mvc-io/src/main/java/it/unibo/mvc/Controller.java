package it.unibo.mvc;

import java.util.List;

/**
 * Interface controller.
 */
public interface Controller {

    /**
     * This method allows you to set thr next string to be outputted.
     * 
     * @param next contains the next string to be outputted.
     */
    void setNextString(String next);

    /**
     * This method allows you to get the next string to be outputted.
     * 
     * @return the next string to be outputted.
     */
    String getNextString(); 
    /**
     * This method allows you to write something on std out.
     * 
     * @param output contains what u want to display on std out.
     */

    void writeOnStdOut(String output);

    /**
     * This method allows you to get all the previous string outputted.
     * 
     * @return a list of the previous outputted strings.
     */
    List<String> getOuputHistory();
}
