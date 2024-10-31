package com.demo.cleanarquitecture.configuration;

import com.demo.cleanarquitecture.core.repository.UserRepository;
import com.demo.cleanarquitecture.core.usecase.CreateUser;
import com.demo.cleanarquitecture.core.usecase.GetUserById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateUser createUserUseCase(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    public GetUserById getUserByIdUseCase(UserRepository userRepository) {
        return new GetUserById(userRepository);
    }

}
