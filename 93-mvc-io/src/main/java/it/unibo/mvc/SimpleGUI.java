package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */

public final class SimpleGUI {

    // Class Fields
    private final JFrame frame = new JFrame();
    private final SimpleController controller = new SimpleController();

    // Class Constructor
    /**
     * This class construcor contains the whole GUI impl.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);

        /*
         * Configuring the SOUTH part of the Layout
         */
        final JPanel secondPanel = new JPanel(new FlowLayout());
        panel.add(secondPanel, BorderLayout.SOUTH);
        final JButton print = new JButton("PRINT");
        final JButton showHisotry = new JButton("SHOW HISTORY");
        secondPanel.add(print);
        secondPanel.add(showHisotry);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.writeOnStdOut(controller.getNextString());
                textField.setText("");
            }
        });

        showHisotry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(controller.getOuputHistory().toString());
            } 
        });
    }

    //Class Method

    /**
     * Method to display the GUI.
     */
    public void display() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Method to launch the GUI.
     * 
     * @param args passed through CLI.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
