package task2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Student {
    private String name;
    private int age;
    private double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }

    //region Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @JsonIgnore
    public double getGPA() {
        return GPA;
    }
    //endregion

    //region Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    //endregion


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }


}
