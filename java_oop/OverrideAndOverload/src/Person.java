public class Person {
  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void greet() {
    System.out.println("我叫" + this.name + "，我今年" + this.age + "岁");
  }
}
