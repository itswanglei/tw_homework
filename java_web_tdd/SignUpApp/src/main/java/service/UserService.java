package service;

import model.User;
import tools.Tools;

import java.io.InputStream;

public class UserService {

    private Tools tools = new Tools();

    public User signUp() {
        String username = this.readUsername(System.in);
        String password = this.readPassword(System.in);
        this.confirmPassword(password, System.in);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        tools.promptSuccessfulSignUp();
        return user;
    }

    public String readUsername(InputStream in) {
        tools.promptInputUsername();
        String username = tools.readSystemIn(in);
        if (username == null) {
            this.tools.promptEmptyUsername();
            throw new EmptyInputException();
        }
        if (!this.verifyUsername(username)) {
            this.tools.promptIllegalUsername();
            throw new IllegalInputException();
        }
        return username;
    }

    private boolean verifyUsername(String username) {
        String pattern = "^\\w+((-\\w+)|(\\.\\w+))*@[A-Za-z0-9]+(([.\\-])[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        return username.matches(pattern);
    }

    public String readPassword(InputStream in) {
        tools.promptInputPassword();
        String password = tools.readSystemIn(in);
        if (password == null) {
            this.tools.promptEmptyPassword();
            throw new EmptyInputException();
        }
        if (!this.verifyPassword(password)) {
            this.tools.promptIllegalPassword();
            throw new IllegalInputException();
        }
        return password;
    }

    private boolean verifyPassword(String password) {
        String matchLetter = "^.*[a-zA-Z]+.*$";
        String matchNumber = "^.*[0-9]+.*$";
        String matchSpecialCharacter = "^.*[\\^$.,;:'!@#%&*|?+()\\[\\]{}_\\-]+.*$";
        boolean hasLetter = password.matches(matchLetter);
        boolean hasNumber = password.matches(matchNumber);
        boolean hasSpecialCharacter = password.matches(matchSpecialCharacter);
        return hasLetter && hasNumber && hasSpecialCharacter && password.length() >= 8;
    }

    public void confirmPassword(String password, InputStream in) {
        tools.promptConfirmPassword();
        String confirmedPassword = tools.readSystemIn(in);
        if (!confirmedPassword.equals(password)) {
            this.tools.promptConfirmPasswordFailed();
            throw new IllegalInputException();
        }
    }
}
