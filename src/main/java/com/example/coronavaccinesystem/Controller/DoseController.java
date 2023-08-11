package com.example.coronavaccinesystem.Controller;

import com.example.coronavaccinesystem.Enum.DoseType;
import com.example.coronavaccinesystem.Model.Dose;
import com.example.coronavaccinesystem.Service.DoseService;
import com.example.coronavaccinesystem.dto.RequestDto.AddDose1Dto;
import com.example.coronavaccinesystem.dto.ResponseDto.AddDose1ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("/get_dose_1")
    public ResponseEntity getDose1(@RequestBody AddDose1Dto addDose1Dto){
        try{
            AddDose1ResponseDto addDose1ResponseDto = doseService.getDose1(addDose1Dto);
            return new ResponseEntity(addDose1ResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
