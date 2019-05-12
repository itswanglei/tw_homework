package service;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void test_read_username() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("admin@admin.com".getBytes());
        String result = userService.readUsername(in);
        assertEquals("admin@admin.com", result);
    }

    @Test(expected = EmptyInputException.class)
    public void test_read_username_when_empty_input() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        String result = userService.readUsername(in);
    }

    @Test(expected = IllegalInputException.class)
    public void test_read_username_when_not_email_address() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("admin".getBytes());
        String result = userService.readUsername(in);
    }

    @Test
    public void test_read_password() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("abc_1234".getBytes());
        String result = userService.readPassword(in);
        assertEquals("abc_1234", result);
    }

    @Test(expected = EmptyInputException.class)
    public void test_read_password_when_empty_input() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        String result = userService.readPassword(in);
    }

    @Test(expected = IllegalInputException.class)
    public void test_read_password_when_input_only_letters() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("abc".getBytes());
        String result = userService.readPassword(in);
    }

    @Test(expected = IllegalInputException.class)
    public void test_read_password_when_input_only_numbers() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        String result = userService.readPassword(in);
    }

    @Test(expected = IllegalInputException.class)
    public void test_read_password_when_input_has_none_special_characters() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("abc123".getBytes());
        String result = userService.readPassword(in);
    }

    @Test(expected = IllegalInputException.class)
    public void test_read_password_when_password_length_less_than_8() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("abc123_".getBytes());
        String result = userService.readPassword(in);
    }

    @Test(expected = IllegalInputException.class)
    public void test_confirmed_password_when_input_different_password_twice() {
        UserService userService = new UserService();
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        userService.confirmPassword("456", in);
    }

}
