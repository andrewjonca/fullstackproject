package com.fullstack.backend.service;

import com.fullstack.backend.Plan;
import com.fullstack.backend.User;
import com.fullstack.backend.UserRole;
import com.fullstack.backend.persistence.repositories.PlanRepository;
import com.fullstack.backend.persistence.repositories.RoleRepository;
import com.fullstack.backend.persistence.repositories.UserRepository;
import com.fullstack.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by akjonca on 2/23/17.
 */

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {
        Plan plan = new Plan(plansEnum);
        if (!planRepository.exists(plansEnum.getId())) {
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);
        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);
        user = userRepository.save(user);

        return user;
    }
}
