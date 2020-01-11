package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class MoneyCalculator {
    private final CurrencyList currencyList = new CurrencyList();
    private double amount;
    private Currency from;
    private Currency to;
    private ExchangeRate exchangeRate;

    
    public ExchangeRate getExchangeRate(Currency from, Currency to) throws IOException {
        if (from == to) return new ExchangeRate(from,to, LocalDate.now(),1);
        URL url = 
            new URL("https://free.currconv.com/api/v7/convert?q=" +
                    from.getIsoCode() + "_" + to.getIsoCode() + "&compact=ultra&apiKey=a6ae7bc6e0a0830df307");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to.getIsoCode())+5, line.indexOf("}"));
            return new ExchangeRate(from,to, LocalDate.now(),Double.parseDouble(line1));
        }
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFrom(String from) {
        this.from = currencyList.isCurrency(from);
    }

    public void setTo(String to) {
        this.to = currencyList.isCurrency(to);
    }

    public double calculateExchange() throws IOException {
        exchangeRate = getExchangeRate(from,to);
        return amount * exchangeRate.getRate();
    }
}