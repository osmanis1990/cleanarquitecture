package com.demo.cleanarquitecture.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tab_user")
public class UserEntity {
    @Id
    private UUID id;

    private String name;

    private String lastName;

    private String email;

    private String password;

}
