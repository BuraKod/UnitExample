package customAssert;


import assertJ.CustomerAssert;
import assertJ.CustomerRepositoryAssert;
import assertJ.CustomerServiceAssert;
import assertJ.NotificationServiceAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerAssertTest {
    private CustomerRepositoryAssert customerRepositoryAssert;
    private NotificationServiceAssert notificationServiceAssert;
    private CustomerServiceAssert customerServiceAssert;

    public static final String USERNAME = "test";
    public static final String EMAIL = "test@test.com";

    @Before
    public void setUp() throws Exception{
        customerServiceAssert = new CustomerServiceAssert();
        customerRepositoryAssert = Mockito.mock(CustomerRepositoryAssert.class);
        notificationServiceAssert = Mockito.mock(NotificationServiceAssert.class);

        customerServiceAssert.setCustomerRepositoryAssert(customerRepositoryAssert);
        customerServiceAssert.setNotificationServiceAssert(notificationServiceAssert);
    }
    @Test

    public void testCustomAssert() {
        CustomerAssert customerAssert = customerServiceAssert.handleNewCustomerAssert(USERNAME,EMAIL);

        // Müşteri listesinin kaydedildiğini kontrol ediyoruz.
        Mockito.verify(customerRepositoryAssert).save(customerAssert);
        Mockito.verify(customerRepositoryAssert).save(Mockito.any(CustomerAssert.class));

        Mockito.verify(notificationServiceAssert).sendWelcomeNotification(USERNAME,EMAIL);

        // Hediye Listesinin null olup olmadığını kontrol edelim
        Assert.assertNotNull(customerAssert.getGiftList());
        // Hediye listesinin iki tane elemandan oluşup oluşmadığını kontrol edelim.
        Assert.assertEquals(2,customerAssert.getGiftList().size());
        // Hediye Listesinin elemanlarını  kontrol edelim
        Assert.assertEquals("gift1",customerAssert.getGiftList().get(0).getName());
        Assert.assertEquals("gift2",customerAssert.getGiftList().get(1).getName());

    }

    @Test
    public void testCustomAsert1() {
        CustomerAssert customerAssert = customerServiceAssert.handleNewCustomerAssert(USERNAME,EMAIL);
        assertThatCustomer(customerAssert)
                .isSaved()
                .hasReceivedWelcomeNotification()
                .hasGifts(2)
                .hasGiftWithName("gift1")
                .hasGiftWithName("gift2");
    }


    public CustomerAssertJ assertThatCustomer(CustomerAssert customerAssert){
        return new CustomerAssertJ(customerAssert,CustomerAssertJ.class,customerRepositoryAssert,notificationServiceAssert);
    }
}
