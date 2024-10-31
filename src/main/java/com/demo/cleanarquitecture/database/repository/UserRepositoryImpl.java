package com.demo.cleanarquitecture.database.repository;

import com.demo.cleanarquitecture.core.model.User;
import com.demo.cleanarquitecture.core.repository.UserRepository;
import com.demo.cleanarquitecture.database.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User getById(UUID id) {
        return jpaUserRepository.findById(id)
                .map(userMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User not found with id:", id)));
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
