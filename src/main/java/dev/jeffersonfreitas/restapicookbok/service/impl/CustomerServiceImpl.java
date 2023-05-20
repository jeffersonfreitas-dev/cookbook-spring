package dev.jeffersonfreitas.restapicookbok.service.impl;

import dev.jeffersonfreitas.restapicookbok.dto.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.dto.PageableRequestDTO;
import dev.jeffersonfreitas.restapicookbok.mapper.CustomerMapper;
import dev.jeffersonfreitas.restapicookbok.model.Customer;
import dev.jeffersonfreitas.restapicookbok.repository.CustomerRepository;
import dev.jeffersonfreitas.restapicookbok.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String DEFAULT_SORT_FIELD = "name";
    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<CustomerResponse> search(@NonNull PageableRequestDTO request) {

        Customer customer = new Customer().filter(request.getFilter(), request.getFilter(), request.getFilter());

        ExampleMatcher customExample = ExampleMatcher.matchingAny().withIgnoreNullValues()
            .withMatcher("uuid", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Customer> example = Example.of(customer, customExample);

        if(!request.getSortField().isBlank()){
            request.setSortField(DEFAULT_SORT_FIELD);
        }

        Sort sort = Sort.by(Sort.Direction.valueOf(request.getDirection()), request.getSortField());
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize(), sort);

        List<CustomerResponse> result = repository.findAll(example, pageRequest)
                .stream().map(c -> CustomerMapper.toResponse(c)).collect(Collectors.toList());
        return new PageImpl<>(result, pageRequest, result.size());
    }

    @Override
    public CustomerResponse create(@NonNull CustomerRequest request) {
        Customer entity = CustomerMapper.toEntity(request);
        entity = repository.save(entity);
        return CustomerMapper.toResponse(entity);
    }
}
