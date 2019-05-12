package model;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class UserTest {
    @Test
    public void test_user_has_field_named_username() {
        User user = new User();
        String username = user.getUsername();
        assertNull(username);
    }

    @Test
    public void test_user_has_field_named_password() {
        User user = new User();
        String password = user.getPassword();
        assertNull(password);
    }
}
