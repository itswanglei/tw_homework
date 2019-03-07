public class Student extends Person {
  public Student(String name, int age) {
    super(name, age);
  }

  @Override
  public void greet() {
    System.out.println("我叫" + this.getName() + "，我今年" + this.getAge() + "五岁，我每天都去幼稚园");
  }

  private void classInfor() {
    System.out.println("我想去向日葵班");
  }

  // 重载
  public void classInfor(String klass) {
    System.out.println("我在" + klass);
  }

  public String classInfor(int studentNumber) {
    return "我们班有" + studentNumber + "个小朋友";
  }
}
