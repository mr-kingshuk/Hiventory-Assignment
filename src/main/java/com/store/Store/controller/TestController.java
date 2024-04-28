package com.store.Store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //sending normal data in string format
    @GetMapping("/")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/person")
    public Person getPerson(){
        Person p = new Person();
        p.setName("Kingshuk");
        p.setAge(40);
        return p;
    }
}

class Person{
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
