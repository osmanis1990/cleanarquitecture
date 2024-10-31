package com.demo.cleanarquitecture.database.persistence;

import com.demo.cleanarquitecture.core.domain.User;
import com.demo.cleanarquitecture.core.persistence.UserRepository;
import com.demo.cleanarquitecture.database.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        return userMapper.toDomain(jpaUserRepository.findAll());
    }

    @Override
    public User save(User user) {
        return Optional.ofNullable(userMapper.toEntity(user))
                .map(jpaUserRepository::save)
                .map(userMapper::toDomain)
                .orElseThrow(() -> new PersistenceException(("User on save user")));
    }

    @Override
    public void delete(UUID id) {
        jpaUserRepository.deleteById(id);
    }
}
