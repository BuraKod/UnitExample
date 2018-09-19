package main.customer;

/*
* Bu class bir database olarak düşülmüştür.
* Gerçek hayatta oracle gibi bir database olarak düşünebiliriz.
*/

public class CustomerRepository {
    public void add(Customer customer){
        System.out.println("Added customer");
    }
    public void delete(Integer customerID){
        System.out.println("Delete customer");
    }
    public Customer Search(Integer customerId){
        System.out.println("Musteri bulunma eylemi");
        return null;
    }
}
