package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * This method allows you to set thr next string to be outputted.
     * 
     * @param next contains the next string to be outputted.
     */
    public void setNextString(final String next);

    /**
     * This method allows you to get the next string to be outputted.
     * 
     * @return the next string to be outputted.
     */
    public String getNextString(); 
    /**
     * This method allows you to write something on std out.
     * 
     * @param output contains what u want to display on std out.
     */
    public void writeOnStdOut(final String output);

    /**
     * This method allows you to get all the previous string outputted.
     * 
     * @return a list of the previous outputted strings.
     */
    public List<String> getOuputHistory();
}
