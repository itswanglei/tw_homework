package main.java.company.package3;

public class SonOverrideCloneInPackage3 extends FatherInPackage3 {
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
