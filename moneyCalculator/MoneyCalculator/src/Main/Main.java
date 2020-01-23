package Main;

import control.MoneyCalculatorControler;
import model.MoneyCalculator;
import view.MoneyCalculatorDisplay;

public class Main {
    
    public static void main(String[] args) {
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        MoneyCalculatorDisplay display = new MoneyCalculatorDisplay();
        MoneyCalculatorControler controler = new MoneyCalculatorControler(moneyCalculator, display);
        display.setVisible(true);
    }  
}
