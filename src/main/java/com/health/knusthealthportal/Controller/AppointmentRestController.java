package com.health.knusthealthportal.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.health.knusthealthportal.Repository.AppointmentRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
public class AppointmentRestController {

    private final AppointmentRepository service;

    public AppointmentRestController(AppointmentRepository service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAll(Model model){
        List<Appointment> appointments =  service.findAll();
        return "account.html";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        service.findAll();
        return "sign-up";
    }

    @PostMapping("/add")
    public String create (Model model, Appointment appointment){
        service.save(appointment);
        return  "booking.html";
    }

    @RequestMapping("/update/{id}")
    public String   update (@PathVariable("id") Long id , @RequestBody Appointment appointment){
         service.save(appointment);
        return "booking.html";
    }

    @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable("id") Long id){
        service.deleteById(id);
        return "account.html";
    }

}
