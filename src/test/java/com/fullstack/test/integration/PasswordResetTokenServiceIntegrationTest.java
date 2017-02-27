package com.fullstack.test.integration;

import com.fullstack.backend.persistence.domain.backend.PasswordResetToken;
import com.fullstack.backend.persistence.domain.backend.User;
import com.fullstack.backend.service.PasswordResetTokenService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by akjonca on 2/26/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordResetTokenServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @Test
    public void testCreateNewTokenForUserEmail() throws Exception {

        User user = createUser();

        PasswordResetToken passwordResetToken =
                passwordResetTokenService.createPasswordResetTokenForEmail(user.getEmail());
        Assert.assertNotNull(passwordResetToken);
        Assert.assertNotNull(passwordResetToken.getToken());
    }

    @Test
    public void testFindByToken() throws Exception {

        User user = createUser();

        PasswordResetToken passwordResetToken =
                passwordResetTokenService.createPasswordResetTokenForEmail(user.getEmail());
        Assert.assertNotNull(passwordResetToken);
        Assert.assertNotNull(passwordResetToken.getToken());

        PasswordResetToken token = passwordResetTokenService.findByToken(passwordResetToken.getToken());
        Assert.assertNotNull(token);

    }

}
