package com.fullstack.backend.persistence.repositories;

import com.fullstack.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by akjonca on 2/23/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
