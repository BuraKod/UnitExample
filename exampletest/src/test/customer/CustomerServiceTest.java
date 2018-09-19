package customer;

import main.customer.Customer;
import main.customer.CustomerService;
import main.customer.InfoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class CustomerServiceTest {
    private CustomerService customerService;
    private CustomerRepositoryStub customerRepository = new CustomerRepositoryStub();  // Stub nesnesi (Stub yöntemi)
    private InfoService infoService;

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService();
        //customerRepository = Mockito.mock(CustomerRepository.class);  // Mock yöntemi

        infoService = Mockito.mock(InfoService.class);
        customerService.setCustomerRepository(customerRepository);
        customerService.setInfoService(infoService);
    }

    @Test
    public void testAddCustomer(){
        Customer customer = new Customer(1234);

        customerService.addCustomer(customer);

        // TODO: 12.09.2018  Testin her yerde çalışması ve  bağımsız şekilde çalışabilmesi için Mock(sahte nesne) kullanılmalıdır.

        // Bilgilendirme service nesnesinin yeni kayıt mail gönder metodunun çağrıldığını ve paremetre olarak Müsteri nesnesi verildiğini control et...
        //Mockito.verify(infoService).sendNewCustomerMail(customer);
        //Mockito.verify(customerRepository).add(customer);

        // TODO: 13.09.2018 Burada ekle(add) dediğimizde verimiz önce customerRepository e eklendi ve sonra bizde bunu verdiğimiz listede var mı diye test ettik.
        //assertTrue(customerRepository.getCustomerList().containsValue(customer));

        // Müsteri bulma eylemi ile listeden çekmeden müşterinin search nesnesinde verilen değerle eşitliğini sorguladık.
        assertEquals(customer,customerRepository.Search(customer.getId()));

    }

    // TODO: 13.09.2018  Burda dikkat edilmesi gereken şey önce ekle metodu çalışması yoksa bütün class test edilirse hata verebilir.
    @Test
    public void testDeleteCustomer() {

        // tododa yazan durum için önce bir müşteri oluşturulup daha sonra delete işlemi yapılıyor.
        customerService.addCustomer(new Customer(1234));

        /*
        *testAddCustomer(); bu şekildede çalışır ama bu yanlış bir kullanımdır.
        * o metoda bağımlı olmak ordaki değişikliklerden etkilenmek demektir.
        * Bu yanlış bir kullanımdır.
        */

        customerService.deleteCustomer(1234);

        assertNull(customerRepository.Search(1234));
    }

    // Test işlemlerinden sonra sonuç ne olursa olsun bütün listeyi silerek stub temizliyoruz.
    @After
    public void tearDown() throws Exception {
        customerRepository.allDelete();
    }
}

//  Stub kullanmak çoğu zaman zahmetli bir iştir. Burada mock kullanımının daha doğru olduğunu düşünebiliriz.
//   Bizim burdaki sorumluluğumuz aslında müşteri servisinin işleyişidir.
//   Burada ki işlemlerin asıl mantığı bizim müşterinin kaydedilip edilmediğini veya diğer işlemleri yapılıp yapılmadığı değildir.
//   Asıl amaç dış bağımlıkların doğru bir şekilde çaprılıp çarılmadığını görmek kod kalitesini artırmaktır.