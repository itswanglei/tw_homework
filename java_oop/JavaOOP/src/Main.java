import model.Student;

public class Main {

  public static void main(String[] args) {
    Student student = new Student("野原新之助", 5, "男", 1234567890);
    student.setName("王蕾");
    student.setAge(25);
    student.setGender("女");
    student.setId(2016140549);
    System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getGender() + ", " + student.getId());
  }
}
