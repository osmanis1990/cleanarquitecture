package com.demo.cleanarquitecture.core.persistence;

import com.demo.cleanarquitecture.core.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {

    User getById(UUID id);

    List<User> getAll();

    User save(User user);

    void delete(UUID id);

}
