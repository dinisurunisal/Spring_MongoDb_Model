package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/create")    //http://localhost:8080/create?firstName=Jack&lastName=Owen&age=25
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        Person p = personService.create(firstName, lastName, age);
        return p.toString();
    }

    @RequestMapping("/get")  //http://localhost:8080/get?firstName=Tom
    public Person getPerson(@RequestParam String firstName) {
        return personService.getByFirstName(firstName);
    }

    @RequestMapping("/getAll")  //http://localhost:8080/getAll
    public List<Person> getAll(){
        return personService.getAll();
    }

    @RequestMapping("/update")  //http://localhost:8080/update?firstName=Tom&lastName=Sparrow&age=3
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age){
        Person p = personService.update(firstName, lastName, age);
        return p.toString();
    }

    @RequestMapping("/delete")  //http://localhost:8080/delete?firstName=Tom
    public String delete(@RequestParam String firstName) {
        personService.delete(firstName);
        return "Deleted" +firstName;
    }

    @RequestMapping("/deleteAll")  //http://localhost:8080/deleteAll
    public String deleteAll() {
        personService.deleteAll();
        return "Deleted All";
    }

}
