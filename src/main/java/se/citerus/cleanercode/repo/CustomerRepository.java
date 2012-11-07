package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.model.Customer;

import java.util.List;

/**
 *
 */
public interface CustomerRepository {
    List<Customer> getNewCustomers();
}
