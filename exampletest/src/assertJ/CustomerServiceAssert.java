package assertJ;

public class CustomerServiceAssert {
    public void setCustomerRepositoryAssert(CustomerRepositoryAssert customerRepositoryAssert) {
        this.customerRepositoryAssert = customerRepositoryAssert;
    }

    public void setNotificationServiceAssert(NotificationServiceAssert notificationServiceAssert) {
        this.notificationServiceAssert = notificationServiceAssert;
    }

    private CustomerRepositoryAssert customerRepositoryAssert;
    private NotificationServiceAssert notificationServiceAssert;

    public CustomerAssert handleNewCustomerAssert(String customerName,String customerEmail){
        CustomerAssert customerAssert = new CustomerAssert(customerName,customerEmail);

        giveWelcomeGifts(customerAssert);
        customerRepositoryAssert.save(customerAssert);
        notificationServiceAssert.sendWelcomeNotification(customerName,customerEmail);

        return customerAssert;
    }

    private void giveWelcomeGifts(CustomerAssert customerAssert){
        customerAssert.addGift(new Gift("gift1"));
        customerAssert.addGift(new Gift("gift2"));
    }
}
