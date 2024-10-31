package com.demo.cleanarquitecture.configuration;

import com.demo.cleanarquitecture.core.repository.UserRepository;
import com.demo.cleanarquitecture.database.mapper.UserMapper;
import com.demo.cleanarquitecture.database.repository.JpaUserRepository;
import com.demo.cleanarquitecture.database.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public UserRepository userRepository(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        return new UserRepositoryImpl(jpaUserRepository, userMapper);
    }
}
