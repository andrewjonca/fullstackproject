package com.fullstack.test.integration;

import com.fullstack.backend.persistence.domain.backend.Role;
import com.fullstack.backend.persistence.domain.backend.User;
import com.fullstack.backend.persistence.domain.backend.UserRole;
import com.fullstack.backend.service.UserSecurityService;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by akjonca on 2/24/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSecurityServiceTest {

    @Autowired
    UserSecurityService userSecurityService;

    @Autowired
    UserService userService;

    @Rule
    public TestName testName = new TestName();

    @Test
    public void testLoadingUserByUsernameWhenUserExists() {

        Set<UserRole> userRoles = new HashSet<>();
        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@gmail.com";
        User basicUser = UserUtils.createBasicUser(username, email);
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);

        UserDetails userDetails = userSecurityService.loadUserByUsername(username);
        Assert.assertNotNull(userDetails);
        Assert.assertNotNull(userDetails.getAuthorities());
        Collection<? extends GrantedAuthority> authorities =  userDetails.getAuthorities();
        Assert.assertTrue(authorities.size() == 1);
        authorities.forEach(ga -> Assert.assertEquals(RolesEnum.BASIC.getRoleName(), ga.getAuthority()));

    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadingUserByUsernameWhenUserDoesNotExists() {
        userSecurityService.loadUserByUsername("lola");

    }
}
