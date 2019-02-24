package main.java.company;

public class Main {

    public static final String ORIGIN_DIRECTORY = "./docs/users";
    public static final String TARGET_PATH = "./docs";

    public static void main(String[] args) {
        Copy copy = new Copy(ORIGIN_DIRECTORY, TARGET_PATH);
        copy.copyDirectory();
        copy.copyFiles();
    }
}
