package com.example.coronavaccinesystem.Controller;

import com.example.coronavaccinesystem.Model.Person;
import com.example.coronavaccinesystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person){
        try{
            Person pr=personService.addPerson(person);
            return new ResponseEntity(pr, HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity("Email already exist", HttpStatus.NOT_ACCEPTABLE);
        }
    }



}
