package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.model.Customer;

import java.util.List;

/**
 *
 */
public class InMemCustomerRepository implements CustomerRepository {
    private final List<Customer> customers;

    public InMemCustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getNewCustomers() {
        return customers;
    }
}
