package view;

import control.MoneyCalculatorControler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MoneyCalculatorDisplay extends JFrame {
    private final JTextField amount = new JTextField(10);
    private final JComboBox comboFrom = new JComboBox();
    private final JComboBox comboTo = new JComboBox();
    JButton convertButton = new JButton("convert");
    JTextField exchange = new JTextField(10);    

    public MoneyCalculatorDisplay() {
        this.setTitle("MoneyCalculator");
        JPanel P = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        P.add(amount);
        P.add(comboFrom);
        comboFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //rellenaComboTo((String) comboFrom.getSelectedItem());
            }
        });

        comboTo.addItem("EUR");
        comboTo.addItem("USD");
        comboTo.addItem("GBP");
        comboTo.addItem("JPY");

        comboFrom.addItem("EUR");
        comboFrom.addItem("USD");
        comboFrom.addItem("GBP");
        comboFrom.addItem("JPY");
        
        P.add(comboTo);
        P.add(convertButton);
        P.add(exchange);
        exchange.setEditable(false);
        
        this.add(P);
        pack();
    }

    public double getAmount() {
        return Double.parseDouble(amount.getText());
    }
    
    public String getFrom() {
        return comboFrom.getSelectedItem().toString();
    }
    
    public String getTo() {
        return comboTo.getSelectedItem().toString();
    }

    public void setExchange(double exchange) {
        this.exchange.setText(String.format("%.3f", exchange));
    }

    public void addRateListener(ActionListener convertListener) {
        convertButton.addActionListener(convertListener);
    }
}