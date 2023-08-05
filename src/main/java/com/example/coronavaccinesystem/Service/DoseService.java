package com.example.coronavaccinesystem.Service;

import com.example.coronavaccinesystem.Enum.DoseType;
import com.example.coronavaccinesystem.Exception.DoseAlreadyTakenException;
import com.example.coronavaccinesystem.Exception.PersonNotFoundException;
import com.example.coronavaccinesystem.Model.Dose;
import com.example.coronavaccinesystem.Model.Person;
import com.example.coronavaccinesystem.Repositary.DoseRepository;
import com.example.coronavaccinesystem.Repositary.PersonRepository;
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

    public Dose getDose1(int personId, DoseType dosetype) {

        Optional<Person>optionalPerson=personRepository.findById(personId);
        if(!optionalPerson.isPresent()){
            throw new PersonNotFoundException("Invalid PersonId");
        }
        Person person=optionalPerson.get();
        if(person.isDose1taken()){
            throw new DoseAlreadyTakenException("Dose 1 already taken");
        }

        Dose dose =new Dose();

        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(dosetype);
        dose.setPerson(person);
        person.setDose1taken(true);

        personRepository.save(person);

        return doseRepository.save(dose);

    }
}
