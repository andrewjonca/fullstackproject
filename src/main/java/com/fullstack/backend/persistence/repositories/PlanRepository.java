package com.fullstack.backend.persistence.repositories;

import com.fullstack.backend.persistence.domain.backend.Authority;
import com.fullstack.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by akjonca on 2/23/17.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
