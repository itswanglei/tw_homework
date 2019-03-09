package main.java.company.package2;

import main.java.company.package3.FatherInPackage3;

public class SonInPackage2 extends FatherInPackage3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        SonInPackage2 sonInPackage2 = new SonInPackage2();
        sonInPackage2.clone(); // 继承性：Object -> FatherInPackage3 -> SonInPackage2，Object的clone方法对Father可见，Father的clone方法对Son可见
    }
}
