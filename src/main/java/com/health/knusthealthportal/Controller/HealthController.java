package com.health.knusthealthportal.Controller;


import com.health.knusthealthportal.Service.HealthService;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>>  getAll(){
        List<Appointment> appointments =  healthService.findAll();
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Appointment> create (@RequestBody Appointment appointment){
        Appointment newAppointment = healthService.createAppointment(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Appointment> update (@RequestBody Appointment appointment){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity delete (@PathVariable("id") Long id){
        healthService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
