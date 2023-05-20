package dev.jeffersonfreitas.restapicookbok.controller;


import dev.jeffersonfreitas.restapicookbok.dto.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.mapper.PageToPageDTOMapper;
import dev.jeffersonfreitas.restapicookbok.model.Customer;
import dev.jeffersonfreitas.restapicookbok.model.PageDTO;
import dev.jeffersonfreitas.restapicookbok.service.CustomerService;
import dev.jeffersonfreitas.restapicookbok.utils.PageSettings;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Validated
@RestController
@RequestMapping("v1/customers")
public class CustomerController {

    private final CustomerService service;
    private PageToPageDTOMapper<Customer> pageToPageDTOMapper;

    @Autowired
    public CustomerController(CustomerService service, PageToPageDTOMapper<Customer> pageToPageDTOMapper) {
        this.service = service;
        this.pageToPageDTOMapper = pageToPageDTOMapper;
    }

    @GetMapping("/page")
    public PageDTO<Customer> getCustomers(PageSettings pageSettings) {
        log.info("Request for customers page received with data: " + pageSettings);
        return pageToPageDTOMapper.pageToPageDTO(service.getCustomers(pageSettings));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody @Valid CustomerRequest request) {
        return service.create(request);
    }
}
