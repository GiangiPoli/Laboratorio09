package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple controller implementation.
 * 
 */
public final class SimpleController implements Controller {

    // Class Fields
    private final List<String> previousOutput = new LinkedList<>();
    private String nextToBeOutput;

    // Class Constructor
    /**
     * Empty Constructor.
     */
    public SimpleController() {
        /*
         * It does nothing
         */
    }

    // Class Method

    /**
     * Set the next String.
     */
    @Override
    public void setNextString(final String next) {
        this.nextToBeOutput = next;
    }

    /**
     * Get the next String.
     */
    @Override
    public String getNextString() {
        return this.nextToBeOutput;
    }

    /**
     * Output the next String.
     */ 
    @Override
    public void writeOnStdOut(final String output) {
        try {
            if (output.isBlank() || output.isEmpty()) {
                throw new IllegalStateException("String Content Unset");
            }
            System.out.println(this.nextToBeOutput); // NOPMD
            previousOutput.add(this.nextToBeOutput);
        } catch (final IllegalStateException ignore) { // NOPMD
            System.out.println("EXCEPTION GENERATED -> " + ignore.getMessage()); //NOPMD
        }

    }

    /**
     * Output the hostory.
     */
    @Override
    public List<String> getOuputHistory() {
        final List<String> res = new LinkedList<>();
        res.addAll(this.previousOutput);
        return res;
    }

}
