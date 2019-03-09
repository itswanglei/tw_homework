package main.java.company.package2;

import main.java.company.package1.FatherInPackage1;

public class SonInDifferentPackage extends FatherInPackage1 {
    public static void main(String[] args) {
        FatherInPackage1 fatherInPackage1 = new FatherInPackage1();
//        fatherInPackage1.clone(); // Object中的clone只对同包或其子类可见，则对Father类可见，对Father的子类不可见
    }
}
