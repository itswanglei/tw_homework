public class Main {

  public static void main(String[] args) {
    String name = "野原新之助";
    int age = 5;
    Person person = new Person(name, age);
    Student student = new Student(name, age);
    person.greet();
    student.greet();
  }

}
