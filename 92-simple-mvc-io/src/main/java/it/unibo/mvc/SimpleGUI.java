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
    private final JFrame frame = new JFrame("My First Graphical Interface");
    private final Controller controller = new Controller(); 

    // Class Constructor
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
            public void actionPerformed(ActionEvent e) {
                final String textToSave = text.getText();
                controller.writeOnFile(textToSave); 
                text.setText("");
            }

        });
    }

    // Class Method
    private void display() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
