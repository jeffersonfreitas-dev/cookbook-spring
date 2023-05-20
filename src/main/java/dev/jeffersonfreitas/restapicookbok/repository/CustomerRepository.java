package dev.jeffersonfreitas.restapicookbok.repository;

import dev.jeffersonfreitas.restapicookbok.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByNameIgnoreCase(final String name);
}
