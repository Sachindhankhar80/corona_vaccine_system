package com.example.coronavaccinesystem.Service;

import com.example.coronavaccinesystem.Enum.DoseType;
import com.example.coronavaccinesystem.Exception.DoseAlreadyTakenException;
import com.example.coronavaccinesystem.Exception.PersonNotFoundException;
import com.example.coronavaccinesystem.Model.Dose;
import com.example.coronavaccinesystem.Model.Person;
import com.example.coronavaccinesystem.Repositary.DoseRepository;
import com.example.coronavaccinesystem.Repositary.PersonRepository;
import com.example.coronavaccinesystem.dto.RequestDto.AddDose1Dto;
import com.example.coronavaccinesystem.dto.ResponseDto.AddDose1ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PersonRepository personRepository;

//    public Dose getDose1(int personId, DoseType dosetype) {
//
//        Optional<Person>optionalPerson=personRepository.findById(personId);
//        if(!optionalPerson.isPresent()){
//            throw new PersonNotFoundException("Invalid PersonId");
//        }
//        Person person=optionalPerson.get();
//        if(person.isDose1taken()){
//            throw new DoseAlreadyTakenException("Dose 1 already taken");
//        }
//
//        Dose dose =new Dose();
//
//        dose.setDoseId(String.valueOf(UUID.randomUUID()));
//        dose.setDoseType(dosetype);
//        dose.setPerson(person);
//        person.setDose1taken(true);
//        person.getDoseList().add(dose);
//
//        personRepository.save(person);
//
//        return doseRepository.save(dose);
//
//    }

    public AddDose1ResponseDto getDose1(AddDose1Dto addDose1Dto) {

        Optional<Person>optionalPerson=personRepository.findById(addDose1Dto.getPersonId());
        if(!optionalPerson.isPresent()){
            throw new PersonNotFoundException("Invalid PersonId");
        }
        Person person=optionalPerson.get();
        if(person.isDose1taken()){
            throw new DoseAlreadyTakenException("Dose 1 already taken");
        }

        Dose dose =new Dose();

        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(addDose1Dto.getDoseType());
        dose.setPerson(person);
        person.setDose1taken(true);
        person.getDoseList().add(dose);

        Person savedPerson = personRepository.save(person);
        Dose dose1=savedPerson.getDoseList().get(0);
        AddDose1ResponseDto addDose1ResponseDto=new AddDose1ResponseDto();
        addDose1ResponseDto.setDoseId(dose1.getDoseId());
        addDose1ResponseDto.setDoseType(dose1.getDoseType());
        addDose1ResponseDto.setMessage("Dose is successfully injected");

        return addDose1ResponseDto;


//        return doseRepository.save(dose);

    }


    }