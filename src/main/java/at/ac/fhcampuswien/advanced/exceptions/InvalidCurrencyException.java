package at.ac.fhcampuswien.advanced.exceptions;

public class InvalidCurrencyException extends Exception{
    InvalidCurrencyException(){
        super("This currency is not a valid currency");
    }

    InvalidCurrencyException(String message){
        super(message);
    }
}

