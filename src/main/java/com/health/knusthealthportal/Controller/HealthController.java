package com.health.knusthealthportal.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import com.health.knusthealthportal.Repository.HealthRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;

@RestController
public class HealthController {

    private final HealthRepository service;

    public HealthController(HealthRepository service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>>  getAll(){
        List<Appointment> appointments =  service.findAll();
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Appointment> create (Appointment appointment){
        Appointment newAppointment = service.save(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<Appointment> update (@PathVariable("id") Long id , @RequestBody Appointment appointment){
         Appointment result =  service.save(appointment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity delete(@PathVariable("id") Long id){
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
