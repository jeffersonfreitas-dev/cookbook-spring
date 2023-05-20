package dev.jeffersonfreitas.restapicookbok.service.impl;

import dev.jeffersonfreitas.restapicookbok.dto.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.mapper.CustomerMapper;
import dev.jeffersonfreitas.restapicookbok.model.Customer;
import dev.jeffersonfreitas.restapicookbok.repository.CustomerRepository;
import dev.jeffersonfreitas.restapicookbok.service.CustomerService;
import dev.jeffersonfreitas.restapicookbok.utils.PageSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Customer> getCustomers(@NonNull PageSettings pageSettings) {
        Sort customerSort = pageSettings.buildSort();
        Pageable customerPage = PageRequest.of(pageSettings.getPage(), pageSettings.getElementPerPage(), customerSort);
        return repository.findAll(customerPage);
    }

    @Override
    public CustomerResponse create(CustomerRequest request) {
        Customer entity = CustomerMapper.toEntity(request);
        entity = repository.save(entity);
        return CustomerMapper.toResponse(entity);
    }
}
