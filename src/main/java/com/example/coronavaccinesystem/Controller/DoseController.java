package com.example.coronavaccinesystem.Controller;

import com.example.coronavaccinesystem.Enum.DoseType;
import com.example.coronavaccinesystem.Model.Dose;
import com.example.coronavaccinesystem.Service.DoseService;
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
    public ResponseEntity getDose1(@RequestParam("id") int personId, @RequestParam("doseType")DoseType doseType){
        try{
            Dose doseTake = doseService.getDose1(personId, doseType);
            return new ResponseEntity(doseTake,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
