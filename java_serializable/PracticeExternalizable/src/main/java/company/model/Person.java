package main.java.company.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeInt(this.age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.age = in.readInt();
    }
}
