package model;

import java.util.ArrayList;
import java.util.List;


public class CurrencyList {
    private List<Currency> currencyList = new ArrayList<>();
    
    public CurrencyList() {
        currencyList.add(new Currency("USD","Dolar americano","$"));
        currencyList.add(new Currency("EUR","Euro","€"));
        currencyList.add(new Currency("GBP","Libra esterlina","£"));
        currencyList.add(new Currency("JPY","Yen","¥"));
    }
    
    public Currency isCurrency(String iso){
        for (Currency aux : currencyList) {
            if(iso.equals(aux.getIsoCode())){
                return aux;
            }
        }
        return null;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }
    
}
