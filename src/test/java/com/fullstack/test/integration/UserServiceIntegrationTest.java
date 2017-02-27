package com.fullstack.test.integration;

import com.fullstack.backend.persistence.domain.backend.Role;
import com.fullstack.backend.persistence.domain.backend.User;
import com.fullstack.backend.persistence.domain.backend.UserRole;
import com.fullstack.backend.service.UserService;
import com.fullstack.enums.PlansEnum;
import com.fullstack.enums.RolesEnum;
import com.fullstack.utils.UserUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by akjonca on 2/23/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testCreateNewUser() throws Exception {
        User user = createUser();
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

    }

    @Test
    public void testServiceUpdateUserPassword() throws Exception {
        User user = createUser();
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

        String newPassword = UUID.randomUUID().toString();

        userService.updateUserPassword(user.getId(), newPassword);

        user = userService.findUserByUsername(user.getUsername());

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertTrue(passwordEncoder.matches(newPassword, user.getPassword()));
    }

}
