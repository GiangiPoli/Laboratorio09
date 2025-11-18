package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    // Class Fields
    private static final String FRAME_TITLE = "My second graphical interface";
    private final JFrame frame = new JFrame(FRAME_TITLE);
    private final Controller controller = new Controller();

    /**
     * Constructor to Implement the GUI.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Creating the Browse Field and Button.
         */
        final JPanel secondPanel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        final JButton browse = new JButton("Browse...");
        panel.add(secondPanel, BorderLayout.NORTH);
        textField.setEditable(false);
        secondPanel.add(textField, BorderLayout.CENTER);
        secondPanel.add(browse, BorderLayout.LINE_END);
        /*
         * Creating the Text Area and Button to Save.
         */
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("SAVE");
        panel.add(text, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser choose = new JFileChooser();
                switch (choose.showSaveDialog(choose)) { 
                    case JFileChooser.APPROVE_OPTION -> {
                        final File file = choose.getSelectedFile();
                        textField.setText(file.getAbsolutePath());
                        controller.setCurrentFile(file);
                    }
                    case JFileChooser.CANCEL_OPTION -> {
                        /*
                         * I do nothing in this case.
                         */
                    }
                    case JFileChooser.ERROR_OPTION -> {
                        JOptionPane.showMessageDialog(frame, "SI E' VERIFICATO UN PROBLEMA");
                    }
                    default -> {
                        /*
                         * Do nothing
                         */
                    }
                }

            }

        });
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.writeOnFile(text.getText()); 
                text.setText("");
            }

        });
    }

    // Class Method
    /**
     * Method to manage the GUI display.
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
        new SimpleGUIWithFileChooser().display();
    }
}
