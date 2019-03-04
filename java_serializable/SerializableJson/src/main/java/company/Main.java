package main.java.company;

import com.alibaba.fastjson.JSON;
import main.java.company.model.Person;

public class Main {

    public static void main(String[] args) {
//        Person person = new Person("张三", 20, "男");
//
//        System.out.println(person);
//
//        String objectToJson = JSON.toJSONString(person);
//        System.out.println(objectToJson);
//
//        Person personFromJson = JSON.parseObject(objectToJson, Person.class);
//        System.out.println(personFromJson);

        MyJSON myJSON = new MyJSON();
        String JSONString = myJSON.readFile("./json/Movie.json");
        System.out.println(JSONString);
        System.out.println(myJSON.isJSON(JSONString));
    }
}
