package main.customer;

public class InfoService {

    public void sendNewCustomerMail(Customer customer){
        System.out.println("Send Message.");
    }
    public void sendWeeklyMail(){
        throw new MailServerUnavailabException("Mail Server Error");
    }
}
