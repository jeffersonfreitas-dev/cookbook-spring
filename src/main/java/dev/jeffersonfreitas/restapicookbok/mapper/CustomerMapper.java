package dev.jeffersonfreitas.restapicookbok.mapper;

import dev.jeffersonfreitas.restapicookbok.dto.customer.CustomerRequest;
import dev.jeffersonfreitas.restapicookbok.dto.customer.CustomerResponse;
import dev.jeffersonfreitas.restapicookbok.model.Customer;


public class CustomerMapper {

    public static Customer toEntity(CustomerRequest request) {
        return new Customer().create(request.getName(), request.getCode(), request.getBirthDate());
    }

    public static CustomerResponse toResponse(Customer entity) {
        return CustomerResponse.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .code(entity.getCode())
                .birthDate(entity.getBirthDate())
                .build();
    }
}
