package customer;

import main.customer.Customer;
import main.customer.CustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryStub extends CustomerRepository {

    private Map<Integer,Customer> customerList = new HashMap<Integer, Customer>();


    @Override
    public void add(Customer customer) {
        customerList.put(customer.getId(),customer);
    }

    @Override
    public void delete(Integer customerId) {
        customerList.remove(customerId);
    }

    public Map<Integer, Customer> getCustomerList() {
        return customerList;
    }

    @Override
    public Customer Search(Integer customerId) {
        return customerList.get(customerId);
    }

    public void allDelete() {
        customerList.clear();
    }
}
