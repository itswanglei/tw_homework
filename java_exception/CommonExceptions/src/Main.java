import java.lang.reflect.Array;

public class Main {

  public static void main(String[] args) {
//    int[][] arr = new int[2][];
//    try {
//      arr[0][1] = 1;
//    } catch (NullPointerException e) {
//      System.out.println("发生异常：" + e.getMessage());
//    }

//    try {
//      Class.forName("anotherPackage");
//    } catch (ClassNotFoundException e) {
//      System.out.println("发生异常：" + e.getMessage());
//    }

//    int a = 1;
//    int b = 0;
//    try {
//      int result = a / b;
//    } catch (ArithmeticException e) {
//      System.out.println("发生异常：" + e.getMessage());
//    }

//    int[] arr = new int[4];
//    try {
//      for (int i = 0; i < arr.length + 1; i++) {
//        arr[i] = 1;
//      }
//    } catch (ArrayIndexOutOfBoundsException e) {
//      System.out.println("发生异常：" + e.getMessage());
//    }

    try {
      int arr = 0;
      Array.getLength(arr);
    } catch (IllegalArgumentException e) {
      System.out.println("发生异常：" + e.getMessage());
    }
  }
}
