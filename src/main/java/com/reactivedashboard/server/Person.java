package com.reactivedashboard.server;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Person {

    private String name;
    private int age;
    private ArrayList<Person> relatives;

    // Constructor
    public Person () {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {

        this.name = name;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelatives(ArrayList<Person> relatives) {
        this.relatives = relatives;
    }

    public void addRelative(Person relative) {
        this.relatives.add(relative);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(ArrayList<Person> relatives) {
        this.relatives = relatives;
    }


    @Override
    public String toString() {
        return "Person is {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
