package main.customer;

public class CustomerService {
    private CustomerRepository customerRepository;
    private InfoService infoService;

    public void addCustomer(Customer customer){
        customerRepository.add(customer);
        infoService.sendNewCustomerMail(customer);
    }

    public void deleteCustomer(Integer customerId){
        customerRepository.delete(customerId);
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


}
