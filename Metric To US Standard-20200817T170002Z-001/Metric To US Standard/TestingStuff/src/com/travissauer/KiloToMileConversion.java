package com.travissauer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiloToMileConversion extends JFrame {

    private JPanel panel;
    private JLabel messageLabel;
    private JTextField kiloTextField;
    private JButton calcButton;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 100;

    public KiloToMileConversion() throws HeadlessException {

        setTitle("Kilometer Conversion");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);


    }

    private void buildPanel() {


        messageLabel = new JLabel("Enter a distance in kilometers");
        messageLabel.setForeground(Color.WHITE);

        kiloTextField = new JTextField(10);

        calcButton = new JButton("Calculate");
        calcButton.setBackground(Color.CYAN);
        calcButton.setForeground(Color.RED);
        calcButton.addActionListener(new CalcButtonListener());

        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
        panel.setBackground(Color.BLACK);

    }

    public static void main(String[] args) {

        new KiloToMileConversion();

    }

    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent buttonClicked){

            // we can use this to determine which button
            // was clicked in a multi-button GUI
            // scenario, although that isn't the case
            // with this simple program
            String actionClicked = buttonClicked.getActionCommand();

            if (actionClicked.equals("Calculate")){

                JOptionPane.showMessageDialog(null, "You clicked, " + calcButton + ".");

            }

            // another method for determining the
            // source of the action event object
            // is as follows
            if (buttonClicked.getSource() == calcButton){

                JOptionPane.showMessageDialog(null, "You HAVE clicked, " + calcButton + ".");

            }

            final double CONVERSION = 0.6214;
            String input;
            double miles;

            input = kiloTextField.getText();

            miles = Double.parseDouble(input) * CONVERSION;

            JOptionPane.showMessageDialog(null, input + " kilometers is " + miles + " miles.");

        }

    }

}
