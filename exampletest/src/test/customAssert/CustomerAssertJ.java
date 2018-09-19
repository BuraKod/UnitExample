package customAssert;

import assertJ.CustomerAssert;
import assertJ.CustomerRepositoryAssert;
import assertJ.NotificationServiceAssert;
import org.assertj.core.api.AbstractAssert;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerAssertJ extends AbstractAssert<CustomerAssertJ, assertJ.CustomerAssert> {
    private CustomerRepositoryAssert customerRepositoryAssert;
    private NotificationServiceAssert notificationServiceAssert;

    public CustomerAssertJ(CustomerAssert customerAssert, Class<?> selfType, CustomerRepositoryAssert customerRepositoryAssert, NotificationServiceAssert notificationServiceAssert) {
        super(customerAssert, selfType);
        this.customerRepositoryAssert = customerRepositoryAssert;
        this.notificationServiceAssert = notificationServiceAssert;
        isNotNull(); // her çalıştığında ilk bunu test etmesi sağlanır.
    }


    public CustomerAssertJ hasGifts(int sizeOfGifts) {

        assertThat(actual.getGiftList())
                .isNotEmpty()
                .hasSize(sizeOfGifts);
        return this;
    }

    public CustomerAssertJ hasGiftWithName(String giftName){

        assertThat(actual.getGiftList())
                .isNotEmpty()
                .extracting("name")
                    .contains(giftName);
        return this;
    }


    public CustomerAssertJ isSaved() {
        Mockito.verify(customerRepositoryAssert).save(Mockito.any(CustomerAssert.class));

        return this;
    }

    public CustomerAssertJ hasReceivedWelcomeNotification() {
        Mockito.verify(notificationServiceAssert).sendWelcomeNotification(CustomerAssertTest.USERNAME,CustomerAssertTest.EMAIL);
        return this;
    }
}
