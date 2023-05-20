package dev.jeffersonfreitas.restapicookbok.controller;


import dev.jeffersonfreitas.restapicookbok.dto.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.dto.PageableRequestDTO;
import dev.jeffersonfreitas.restapicookbok.service.CustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Validated
@RestController
@RequestMapping("v1/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Page<CustomerResponse> fetchAll(@RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Integer size,
                                   @RequestParam(required = false) String direction,
                                   @RequestParam(required = false) String sortField,
                                   @RequestParam(required = false) String filter) {
        PageableRequestDTO pageableDTO = new PageableRequestDTO(page, size, direction, sortField, filter);
        return service.search(pageableDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody @Valid CustomerRequest request) {
        return service.create(request);
    }
}
