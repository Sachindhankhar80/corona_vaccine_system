package com.example.coronavaccinesystem.Model;

import com.example.coronavaccinesystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(nullable = true)
    int age;

    @Column(unique = true,nullable = true)
    String gmail;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
