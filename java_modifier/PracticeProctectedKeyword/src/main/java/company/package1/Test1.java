package main.java.company.package1;

import main.java.company.package2.SonInDifferentPackage;

public class Test1 {
    public static void main(String[] args) throws CloneNotSupportedException {
//        不同包，非Object的子类，无法访问Object的clone方法

        SonInSamePackage sonInSamePackage = new SonInSamePackage();
        sonInSamePackage.method();
//        sonInSamePackage.clone(); // 'clone()' has protected access in 'java.lang.Object'

        SonInDifferentPackage sonInDifferentPackage = new SonInDifferentPackage();
        sonInDifferentPackage.method();
//        sonInDifferentPackage.clone(); // 'clone()' has protected access in 'java.lang.Object'

        Test1 test1 = new Test1();
        test1.clone(); // Object的clone方法对其子类Test1可见
    }
}
