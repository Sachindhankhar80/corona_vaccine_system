package com.example.coronavaccinesystem.Repositary;

import com.example.coronavaccinesystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {


}
