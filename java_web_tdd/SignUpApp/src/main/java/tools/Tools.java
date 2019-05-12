package tools;

import java.io.*;

public class Tools {

    public String readSystemIn(InputStream in) {
        String input = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public void promptInputUsername() {
        System.out.println("请输入用户名：");
    }

    public void promptInputPassword() {
        System.out.println("请输入密码：");
    }

    public void promptConfirmPassword() {
        System.out.println("请再次输入密码：");
    }

    public void promptEmptyUsername() {
        System.out.println("用户名不能为空！");
    }

    public void promptEmptyPassword() {
        System.out.println("密码不能为空！");
    }

    public void promptIllegalUsername() {
        System.out.println("用户名必须为邮箱！");
    }

    public void promptIllegalPassword() {
        System.out.println("密码应包含数组、字母的组合、特殊字符，长度不能小于8位！");
    }


    public void promptConfirmPasswordFailed() {
        System.out.println("两次输入的密码不一致！");
    }

    public void promptSuccessfulSignUp() {
        System.out.println("恭喜您注册成功！");
    }
}
