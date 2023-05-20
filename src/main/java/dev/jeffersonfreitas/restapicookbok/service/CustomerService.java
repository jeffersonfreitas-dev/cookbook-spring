package dev.jeffersonfreitas.restapicookbok.service;

import dev.jeffersonfreitas.restapicookbok.dto.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.model.Customer;
import dev.jeffersonfreitas.restapicookbok.utils.PageSettings;
import org.springframework.data.domain.Page;


public interface CustomerService {

    Page<Customer> getCustomers(PageSettings pageSettings);

    CustomerResponse create(final CustomerRequest request);
}
