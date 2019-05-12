package tools;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ToolsTest {

    @Test
    public void test_read_system_in() {
        Tools tools = new Tools();
        ByteArrayInputStream in = new ByteArrayInputStream("abc".getBytes());
        String result = tools.readSystemIn(in);
        assertEquals("abc", result);
    }

    @Test
    public void test_prompt_input_username() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptInputUsername();
        assertEquals("请输入用户名：\r\n", output.toString());
    }

    @Test
    public void test_prompt_input_password() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptInputPassword();
        assertEquals("请输入密码：\r\n", output.toString());
    }

    @Test
    public void test_prompt_confirm_password() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptConfirmPassword();
        assertEquals("请再次输入密码：\r\n", output.toString());
    }

    @Test
    public void test_prompt_empty_username() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptEmptyUsername();
        assertEquals("用户名不能为空！\r\n", output.toString());
    }

    @Test
    public void test_prompt_empty_password() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptEmptyPassword();
        assertEquals("密码不能为空！\r\n", output.toString());
    }

    @Test
    public void test_prompt_username_must_be_email_address() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptIllegalUsername();
        assertEquals("用户名必须为邮箱！\r\n", output.toString());
    }

    @Test
    public void test_prompt_illegal_password() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptIllegalPassword();
        assertEquals("密码应包含数组、字母的组合、特殊字符，长度不能小于8位！\r\n", output.toString());
    }

    @Test
    public void test_prompt_confirm_password_failed() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptConfirmPasswordFailed();
        assertEquals("两次输入的密码不一致！\r\n", output.toString());
    }

    @Test
    public void test_prompt_successful_sign_up() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Tools tools = new Tools();
        tools.promptSuccessfulSignUp();
        assertEquals("恭喜您注册成功！\r\n", output.toString());
    }
}
