package com.demo.cleanarquitecture.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class User {

    UUID id;

    String name;

    String lastName;

    String email;

    String password;

}
