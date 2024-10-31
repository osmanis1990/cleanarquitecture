package com.demo.cleanarquitecture.core.repository;

import com.demo.cleanarquitecture.core.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {

    User getById(UUID id);

    List<User> getAll();

    User save(User user);

    void delete(UUID id);

}
