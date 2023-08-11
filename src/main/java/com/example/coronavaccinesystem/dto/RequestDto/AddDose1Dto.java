package com.example.coronavaccinesystem.dto.RequestDto;

import com.example.coronavaccinesystem.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddDose1Dto {
    int personId;
    DoseType doseType;
}
