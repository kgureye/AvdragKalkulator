package com.codewithkani;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvdragKalkulatorUI {
    private JFrame frame;
    private JTextField låneSumFelt;
    private JTextField renteFelt;
    private JTextField nedbetalingsFelt;
    private JLabel månedligBetaling;

    public AvdragKalkulatorUI() {
        // Create the frame
        frame = new JFrame("Avdrag kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        // Create the loan amount field
        JLabel låneSumTekst = new JLabel("Lånesum:");
        låneSumFelt = new JTextField();
        frame.add(låneSumTekst);
        frame.add(låneSumFelt);

        // Create the interest rate field
        JLabel renteTekst = new JLabel("Rente (%):");
        renteFelt = new JTextField();
        frame.add(renteTekst);
        frame.add(renteFelt);

        // Create the years to pay field
        JLabel nedbetalingsTekst = new JLabel("Nedbetalingstid");
        nedbetalingsFelt = new JTextField();
        frame.add(nedbetalingsTekst);
        frame.add(nedbetalingsFelt);

        // Create the calculate button
        JButton beregnKnapp = new JButton("Beregn");
        beregnKnapp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMonthlyPayment();
            }
        });
        frame.add(new JLabel());
        frame.add(beregnKnapp);

        // Create the monthly payment label
        JLabel monthlyPaymentTextLabel = new JLabel("Månedlig betaling:");
        månedligBetaling = new JLabel();
        frame.add(monthlyPaymentTextLabel);
        frame.add(månedligBetaling);

        // Set the frame size and make it visible
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private void calculateMonthlyPayment() {
        double låneSum = Double.parseDouble(låneSumFelt.getText());
        double rente = Double.parseDouble(renteFelt.getText());
        int nedbetaling = Integer.parseInt(nedbetalingsFelt.getText());

        // Calculate the monthly payment using your formula
        int antallMåneder = nedbetaling * 12;
        double månedligRente = rente / 12;
        double månedligBetaling = låneSum * månedligRente * Math.pow(1 + månedligRente, antallMåneder)
                / (Math.pow(1 + månedligRente, antallMåneder) - 1);

        // Set the calculated monthly payment in the label
        this.månedligBetaling.setText(String.format("%.2f", månedligBetaling));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AvdragKalkulatorUI();
            }
        });
    }
}
