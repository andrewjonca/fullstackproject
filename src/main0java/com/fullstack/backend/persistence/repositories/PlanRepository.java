package com.fullstack.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by akjonca on 2/23/17.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
