package com.example.coronavaccinesystem.dto.RequestDto;

import com.example.coronavaccinesystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPersonDto {
    String name;
    int age;
    String gmail;
    Gender gender;
}
