package com.example.kadry2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//dodajemy encję
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastName;
    int age;

    //konstruktor pusty - automatycznie genetrowany

    public Employee() {
    }

    public Employee(String firstname, String lastName, int age) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
    }

    //gettery i settery bo hibernate kozysta z nich

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
