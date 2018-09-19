package mockito;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BehaviourTest {
    @Test
    public void testBehaviour() {

        DummyCustomerService dummyCustomerService = mock(DummyCustomerService.class);

        dummyCustomerService.addCustomer("İstanbul");
        dummyCustomerService.addCustomer("İzmir");

        verify(dummyCustomerService).addCustomer("İstanbul");
        verify(dummyCustomerService).addCustomer("İzmir");

    }

    @Test
    public void testHowManyStarted() {

        DummyCustomerService dummyCustomerService = mock(DummyCustomerService.class);

        dummyCustomerService.addCustomer("İstanbul");
        dummyCustomerService.addCustomer("teknasyon");
        dummyCustomerService.addCustomer("teknasyon");
        dummyCustomerService.addCustomer("teknasyon");
        dummyCustomerService.addCustomer("İzmir");

        verify(dummyCustomerService,times(3)).addCustomer("teknasyon");

        // Hiç çağrılmadı
        verify(dummyCustomerService,never()).removeCustomer(anyString());
        verify(dummyCustomerService,never()).addCustomer("Ankara");

        // en az iki kez çağrıldı.
        verify(dummyCustomerService,atLeast(2)).addCustomer("teknasyon");


    }
}
