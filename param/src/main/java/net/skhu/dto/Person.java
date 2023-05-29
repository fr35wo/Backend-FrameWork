package net.skhu.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {
    String name;
    double weight;
    Date birthday;

    public Person() {
    }

    public Person(String name, double weight, Date birthday) {
        this.name = name;
        this.weight = weight;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
