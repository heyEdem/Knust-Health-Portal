package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.health.knusthealthportal.entities.Appointment;

import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentRestController {

   private AppointmentService service;

    public AppointmentRestController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/app")
    public String getAll(Model model){
        List<Appointment> appointments =  service.findAllAppointments();
        model.addAttribute("appointment","appointment");
        return "preview";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String Login(Model model) {
        return "redirect:/";
    }

    @GetMapping("/appointmentForm")
    public String showForm( Appointment appointment){
        return "booking";
    }
    @PostMapping("/appointmentForm")
    public String create (Appointment appointment){
        Appointment result = service.createAppointment(appointment);
        return "appointment-details";
    }

    @GetMapping("/my-appointment")
    public String getAccount() {
        return "appointment-details";
    }

    @GetMapping("/")
        public String home (Model model){
            return "index";
        }


    @RequestMapping("/update/{id}")
    public String update (@PathVariable("id") Long id , @RequestBody Appointment appointment){
         service.updateAppointment(appointment);
         return"booking";
    }

    @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable("id") Long id){
        service.deleteAppointment(id);
        return "account";
    }


}
