package main.java.company.package1;

public class SonInSamePackage extends FatherInPackage1 {
    public static void main(String[] args) {
        FatherInPackage1 fatherInPackage1 = new FatherInPackage1();
//        fatherInPackage1.clone(); // Object的clone方法只对同包和其子类可见，则对Father类可见，对Father类的子类不可见
    }
}
