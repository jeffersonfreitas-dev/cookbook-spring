package dev.jeffersonfreitas.restapicookbok.service;

import dev.jeffersonfreitas.restapicookbok.dto.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.dto.PageableRequestDTO;
import org.springframework.data.domain.Page;


public interface CustomerService {

    CustomerResponse create(final CustomerRequest request);

    Page<CustomerResponse> search(PageableRequestDTO pageableDTO);
}
