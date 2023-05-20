package dev.jeffersonfreitas.restapicookbok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    private String uuid;
    private String name;
    private String code;
    private LocalDate birthDate;

    public Customer(){}

    public Customer create(final String name, final String code, final LocalDate birthDate) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
        this.birthDate = birthDate;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
