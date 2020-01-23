package control;

import model.MoneyCalculator;
import view.MoneyCalculatorDisplay;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MoneyCalculatorControler {
    private MoneyCalculator moneyCalculator;
    private MoneyCalculatorDisplay display;

    public MoneyCalculatorControler(MoneyCalculator moneyCalculator, MoneyCalculatorDisplay display) {
        this.moneyCalculator = moneyCalculator;
        this.display = display;
        this.display.addRateListener(new ConvertListener());
    }


    private class ConvertListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            double amount = 0;
            String from;
            String to;
            double exchange = 1;
            
            try{
                amount = display.getAmount();
                from = display.getFrom();
                to = display.getTo();

                moneyCalculator.setAmount(amount);
                moneyCalculator.setFrom(from);
                moneyCalculator.setTo(to);
                exchange = moneyCalculator.calculateExchange();
                display.setExchange(exchange);
                
            } catch (NumberFormatException ne){
                JOptionPane.showMessageDialog(null, "debe escribir números", "valor inválido", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "error al obtener la tasa de cambio", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
