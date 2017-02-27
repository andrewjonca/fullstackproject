package com.fullstack.utils;

import com.fullstack.backend.persistence.domain.backend.User;
import com.fullstack.web.controllers.ForgotMyPasswordController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by akjonca on 2/23/17.
 */

public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Non instantiable");
    }

    static public User createBasicUser(String username, String email) {
        User user = new User();
        user.setPassword("secret");
        user.setUsername(username);
        user.setFirstName("Bob");
        user.setLastName("Zadzior");
        user.setEmail(email);
        user.setDescription("Long description of the user");
        user.setPhoneNumber("5036907229");
        user.setProfileImageUrl("https://bla");
        user.setCountry("USA");
        user.setEnabled(true);

        return user;
    }

    public static String createPasswordResetUrl(HttpServletRequest request, long userId, String token) {
        String passwordResetUrl =
                request.getScheme() +
                        "://" +
                        request.getServerName() +
                        ":" +
                        request.getServerPort() +
                        request.getContextPath() +
                        ForgotMyPasswordController.CHANGE_PASSWORD_PATH +
                        "?id=" +
                        userId +
                        "&token=" +
                        token;
        return passwordResetUrl;
    }
}
