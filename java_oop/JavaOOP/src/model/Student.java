package model;

public class Student {
  private String name;
  private int age;
  private String gender;
  private long id;

  public Student(String name, int age, String gender, long id) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public String getGender() {
    return this.gender;
  }

  public long getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setId(long id) {
    this.id = id;
  }
}
