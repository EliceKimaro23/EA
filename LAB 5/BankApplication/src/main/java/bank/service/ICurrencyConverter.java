package bank.service;

import org.springframework.stereotype.Component;

@Component
public interface ICurrencyConverter {
    public double euroToDollars (double amount);
    public double dollarsToEuros (double amount);
}
