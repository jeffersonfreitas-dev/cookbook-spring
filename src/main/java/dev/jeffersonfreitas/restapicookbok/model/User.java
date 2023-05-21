package dev.jeffersonfreitas.restapicookbok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String uuid;
    private String username;
    private String password;

    public User () {}

    public User create(final String username, final String password) {
        this.uuid = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
