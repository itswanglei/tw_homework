package main.java.company.package3;

import main.java.company.package2.SonInPackage2;
import main.java.company.package2.SonOverrideClone;

public class FatherInPackage3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        SonInPackage2 sonInPackage2 = new SonInPackage2();
        sonInPackage2.clone(); // 继承性：Object -> FatherInPackage3 -> SonInPackage2，Object的clone方法对Father可见

        SonOverrideClone sonOverrideClone = new SonOverrideClone();
//        sonOverrideClone.clone(); // 不同包父类中无法访问子类的protected方法

        SonOverrideCloneInPackage3 anotherSonInPackage3 = new SonOverrideCloneInPackage3();
        anotherSonInPackage3.clone(); // 同包父类中可以访问子类的protected方法

        TheThirdSonInPackage3 theThirdSonInPackage3 = new TheThirdSonInPackage3();
        theThirdSonInPackage3.clone(); // 子类父类同包，访问的是父类继承自Object类的clone方法
    }
}
