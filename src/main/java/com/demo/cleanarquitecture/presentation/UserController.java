package com.demo.cleanarquitecture.presentation;

import com.demo.cleanarquitecture.core.usecase.CreateUser;
import com.demo.cleanarquitecture.core.usecase.GetUserById;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final GetUserById getUserById;

    public UserController(CreateUser createUser, GetUserById getUserById) {
        this.createUser = createUser;
        this.getUserById = getUserById;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserById.OutputValues> getUserById(@PathVariable UUID id) {
        return Optional.ofNullable(getUserById.execute(GetUserById.InputValues.builder().id(id).build()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUser.OutputValues> createUser(@RequestBody CreateUser.InputValues input) {
        return ResponseEntity.ok(createUser.execute(input));
    }

}
