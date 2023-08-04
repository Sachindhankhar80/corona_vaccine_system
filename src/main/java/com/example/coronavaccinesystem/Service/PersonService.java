package com.example.coronavaccinesystem.Service;

import com.example.coronavaccinesystem.Model.Person;
import com.example.coronavaccinesystem.Repositary.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;


    public Person addPerson(Person person) {
        Person NewPerson=personRepository.save(person);
        return NewPerson;
    }
}
