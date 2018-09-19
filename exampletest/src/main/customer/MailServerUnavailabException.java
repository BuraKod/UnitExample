package main.customer;

public class MailServerUnavailabException extends RuntimeException{
    public MailServerUnavailabException(String message){
        super(message);
    }
}
