package com.example.coronavaccinesystem.Model;

import com.example.coronavaccinesystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int no;

    @Column(nullable = true)
    String name;

    @Column(nullable = true)
    int age;

    @Column(unique = true,nullable = true)
    String gmail;

    @Enumerated(EnumType.STRING)
    Gender gender;





}
