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
     * @{inheritDoc}.
     */
    @Override
    public void setNextString(final String next) {
        this.nextToBeOutput = next;
    }

    /**
     * @{inheritDoc}.
     */
    @Override
    public String getNextString() {
        return this.nextToBeOutput;
    }

    /**
     * @{inheritDoc}.
     */ 
    @Override
    public void writeOnStdOut(final String output) {
        try {
            if (output.isBlank() || output.isEmpty()) {
                throw new IllegalStateException("String Content Unset");
            }
            System.out.println(this.nextToBeOutput); //NOPMD
            previousOutput.add(this.nextToBeOutput);
        } catch (final IllegalStateException e) {
            System.out.println("EXCEPTION GENERATED -> " + e.getMessage()); //NOPMD
        }

    }

    /**
     * @{inheritDoc}.
     */
    @Override
    public List<String> getOuputHistory() {
        return this.previousOutput;
    }
    
}
