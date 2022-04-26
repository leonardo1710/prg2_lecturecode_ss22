package at.ac.fhcampuswien.advanced.exceptions;

public class Currency {
    String currencyCode;

    public Currency(String currencyCode) throws InvalidCurrencyException {
        if(currencyCode.equals("EUR") || currencyCode.equals("USD")){
            this.currencyCode = currencyCode;
        } else {
            throw new InvalidCurrencyException("Currency is not supported yet.");
        }
    }
}


