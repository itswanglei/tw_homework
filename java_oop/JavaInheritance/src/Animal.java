public class Animal {
  private int age;
  private double weight;

  public Animal(int age, double weight) {
    this.age = age;
    this.weight = weight;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void run() {
    System.out.println("This animal can run.");
  }

  public void eat() {
    System.out.println("This animal can eat food.");
  }
}
