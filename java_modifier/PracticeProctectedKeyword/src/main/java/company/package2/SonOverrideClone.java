package main.java.company.package2;

import main.java.company.package3.FatherInPackage3;

public class SonOverrideClone extends FatherInPackage3 {
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
