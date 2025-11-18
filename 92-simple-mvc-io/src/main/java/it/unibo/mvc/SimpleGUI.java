package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    // Class Fields
    private static final String FRAME_TITLE = "My first graphical interface";
    private final JFrame frame = new JFrame(FRAME_TITLE);
    private final Controller controller = new Controller(); 

    // Class Constructor
    /**
     * Constructor to implement the GUI.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("SAVE");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(text, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final String textToSave = text.getText();
                controller.writeOnFile(textToSave); 
                text.setText("");
            }

        });
    }

    // Class Method
    /**
     * Method to manage the disply funciotn.
     */
    private void display() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launch the GUI.
     * 
     * @param args for arguments passed through CLI.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
