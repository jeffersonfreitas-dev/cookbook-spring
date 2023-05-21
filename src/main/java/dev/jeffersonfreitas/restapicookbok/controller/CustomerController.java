package dev.jeffersonfreitas.restapicookbok.controller;


import dev.jeffersonfreitas.restapicookbok.dto.customer.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.customer.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.dto.PageableRequestDTO;
import dev.jeffersonfreitas.restapicookbok.exceptions.ErrorDTO;
import dev.jeffersonfreitas.restapicookbok.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Validated
@RestController
@RequestMapping("v1/customers")
@Tag(name = "Customers", description = "Endpoints for customers operations")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Operation(summary = "Search customers", description = "Search customers with pagination, filters and sorting")
    @Parameters(value = {
        @Parameter(in = ParameterIn.QUERY, description = "Number of page", name = "page"),
        @Parameter(in = ParameterIn.QUERY, description = "Quantity of register in a page", name = "size"),
        @Parameter(in = ParameterIn.QUERY, description = "Direction of sorting (ASC or DESC)", name = "direction"),
        @Parameter(in = ParameterIn.QUERY, description = "Field to be sorting", name = "sortField"),
        @Parameter(in = ParameterIn.QUERY, description = "Field to be filtered", name = "filter")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation",
                    content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "429", description = "Error when size is greather max size",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
    })
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<CustomerResponse> fetchAll(@RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Integer size,
                                   @RequestParam(required = false) String direction,
                                   @RequestParam(required = false) String sortField,
                                   @RequestParam(required = false) String filter) {
        PageableRequestDTO pageableDTO = new PageableRequestDTO(page, size, direction, sortField, filter);
        return service.search(pageableDTO);
    }

    @Operation(summary = "Insert new customer", description = "Insert new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully",
                    content = @Content(schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid values in request body",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
    })
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse create(@RequestBody @Valid CustomerRequest request) {
        return service.create(request);
    }
}
