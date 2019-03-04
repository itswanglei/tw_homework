package main.java.company;

import java.io.File;

public class Main {

    public static final String ORIGIN_DIRECTORY = "./docs/users";
    public static final String TARGET_PATH = "./docs";

    public static void main(String[] args) {
        Copy copy = new Copy(ORIGIN_DIRECTORY, TARGET_PATH);
        copy.copyDirectory();
        copy.copyFiles();

//        File newDir = new File("./docs/copy_of_users");
//        File[] files = newDir.listFiles();
//        if (null == files) {
//            newDir.delete();
//        }
//        for (File file : files) {
//            file.delete();
//        }
//        newDir.delete();
    }
}
