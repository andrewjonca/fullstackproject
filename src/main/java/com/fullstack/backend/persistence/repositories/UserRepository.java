package com.fullstack.backend.persistence.repositories;

import com.fullstack.backend.persistence.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by akjonca on 2/23/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param username
     * @return
     */
    public List<User> findByUsername(String username);
}
