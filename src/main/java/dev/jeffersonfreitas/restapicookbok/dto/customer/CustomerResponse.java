package dev.jeffersonfreitas.restapicookbok.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String uuid;
    private String name;
    private String code;
    private LocalDate birthDate;
}
