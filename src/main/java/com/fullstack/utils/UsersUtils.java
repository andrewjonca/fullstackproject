package com.fullstack.utils;

import com.fullstack.backend.User;

/**
 * Created by akjonca on 2/23/17.
 */

public class UsersUtils {

    private UsersUtils() {
        throw new AssertionError("Non instantiable");
    }

    static public User createBasicUser() {
        User user = new User();
        user.setPassword("secret");
        user.setUsername("basicUser");
        user.setFirstName("Bob");
        user.setLastName("Zadzior");
        user.setEmail("bz@gmail.com");
        user.setDescription("Long description of the user");
        user.setPhoneNumber("5036907229");
        user.setProfileImageUrl("https://bla");
        user.setCountry("USA");
        user.setEnabled(true);

        return user;
    }
}
