package main.java.company.package3;

import main.java.company.package2.FatherOverrideClone;

public class SonInPackage3 extends FatherOverrideClone {
    public static void main(String[] args) throws CloneNotSupportedException {
//        子类与父类不同包时，子类中可以访问子类实例继承来的protected方法，不能访问父类实例的protected方法

        FatherOverrideClone fatherOverrideClone = new FatherOverrideClone();
//        fatherOverrideClone.clone(); // 'clone()' has protected access in 'main.java.company.package2.FatherOverrideClone'

        SonInPackage3 sonInPackage3 = new SonInPackage3();
        sonInPackage3.clone();
    }
}
