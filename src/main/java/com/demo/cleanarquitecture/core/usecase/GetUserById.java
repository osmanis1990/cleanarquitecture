package com.demo.cleanarquitecture.core.usecase;

import com.demo.cleanarquitecture.core.domain.User;
import com.demo.cleanarquitecture.core.persistence.UserRepository;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

public class GetUserById extends UseCase<GetUserById.InputValues, GetUserById.OutputValues> {

    private final UserRepository userRepository;

    public GetUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        User user = userRepository.getById(input.id);
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
        UUID id;
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
