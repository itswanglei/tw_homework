package com.company;

public class PrintVariables {
  byte aByte;
  short aShort;
  int anInt;
  long aLong;
  float aFloat;
  double aDouble;
  boolean aBoolean;
  char aChar;

  public void printVariablesDefaultsValue() {
    System.out.println("default value of byte type: " + aByte);
    System.out.println("default value of short type: " + aShort);
    System.out.println("default value of int type: " + anInt);
    System.out.println("default value of long type: " + aLong);
    System.out.println("default value of float type: " + aFloat);
    System.out.println("default value of double type: " + aDouble);
    System.out.println("default value of boolean type: " + aBoolean);
    System.out.println("default value of char type: " + aChar);
  }

  public void printRangeOfDataType() {
    System.out.println("range of byte type is: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
    System.out.println("range of short type is: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
    System.out.println("range of int type is: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
    System.out.println("range of long type is: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
    System.out.println("range of float type is: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
    System.out.println("range of double type is: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
    System.out.println("value of boolean type is: " + aBoolean + " or " + !aBoolean);
    System.out.println("range of char type is: " + Character.MIN_VALUE + " to " + Character.MAX_VALUE);
  }
}
