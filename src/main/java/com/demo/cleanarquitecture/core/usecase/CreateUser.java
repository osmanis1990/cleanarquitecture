package com.demo.cleanarquitecture.core.usecase;

import com.demo.cleanarquitecture.core.model.User;
import com.demo.cleanarquitecture.core.repository.UserRepository;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

public class CreateUser extends UseCase<CreateUser.InputValues, CreateUser.OutputValues> {

    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        User user = userRepository.save(User.builder()
                .email(input.email)
                .name(input.name)
                .lastName(input.lastName)
                .password(input.password)
                .build());
        return OutputValues.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    @Value
    @Builder
    public static class InputValues implements UseCase.InputValues {
        String name;
        String lastName;
        String email;
        String password;
    }

    @Value
    @Builder
    public static class OutputValues implements UseCase.OutputValues {
        UUID id;
        String name;
        String lastName;
        String email;
    }

}
