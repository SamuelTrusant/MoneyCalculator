package control;

import model.MoneyCalculator;
import view.MoneyCalculatorDisplay;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            double amount;
            String from;
            String to;
            double exchange = 1;
            
            //try {
              amount = display.getAmount();
              from = display.getFrom();
              to = display.getTo();
              
              moneyCalculator.setAmount(amount);
              moneyCalculator.setFrom(from);
              moneyCalculator.setTo(to);
              
              try{ 
                  exchange = moneyCalculator.calculateExchange();
              } catch (IOException ex) {
                  System.out.println("no se puede obtener la tasa");
              }
              display.setExchange(exchange);
        }
    }
}
