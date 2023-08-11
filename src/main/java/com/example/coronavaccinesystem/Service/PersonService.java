package com.example.coronavaccinesystem.Service;

import com.example.coronavaccinesystem.Model.Person;
import com.example.coronavaccinesystem.Repositary.PersonRepository;
import com.example.coronavaccinesystem.dto.RequestDto.AddPersonDto;
import com.example.coronavaccinesystem.dto.ResponseDto.AddPersonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;


//    public Person addPerson(Person person) {
//        Person NewPerson=personRepository.save(person);
//        return NewPerson;
//    }

    public AddPersonResponseDto addPerson(AddPersonDto addPersonDto) {
        Person person = new Person();
        person.setDoseList(null);
        person.setAge(addPersonDto.getAge());
        person.setName(addPersonDto.getName());
        person.setGmail(addPersonDto.getGmail());
        person.setGender(addPersonDto.getGender());

        Person newPerson=personRepository.save(person);
        AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
        addPersonResponseDto.setName(newPerson.getName());
        addPersonResponseDto.setMessage("Person add successfully");

        return addPersonResponseDto;



    }
}
