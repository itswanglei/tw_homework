import model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = userService.signUp();
    }
}
