package dev.jeffersonfreitas.restapicookbok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class User {

    @Id
    private String uuid;
    private String name;
    private String password;

    public User () {}

    public User create(final String name, final String password) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
