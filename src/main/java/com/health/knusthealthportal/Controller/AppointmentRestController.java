package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.health.knusthealthportal.entities.Appointment;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
public class AppointmentRestController {

   private AppointmentService service;

    public AppointmentRestController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home (Model model){
        return "index";
    }


    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @GetMapping("/appointmentForm")
    public String showForm(Model model, Appointment appointment){
        return "doc-booking";
    }

    ////Post Mapping for Doctor's appointment
    @PostMapping("/appointmentForm")
    public String create (Model model, Appointment appointment) {
        Appointment result = service.createAppointment(appointment);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String getAccount(Model model, Appointment appointment) {
         List <Appointment> appointments = service.findAllAppointments();
        System.out.println(appointments);
        model.addAttribute("appointments",appointments);
        return "confirmation-page";
    }


    @PutMapping
    @RequestMapping("/update/{id}")
    public String update (@PathVariable("id") UUID id ){
        service.updateAppointment(id);
         return "redirect:/appointmentForm";
    }


    @RequestMapping("/delete/{id}")
        public String delete(@PathVariable("id") UUID id){
        service.deleteAppointment(id);
        return "redirect:/all-appointments";
    }
    @GetMapping("/all-appointments")
    public String allAppointments(Model model, Appointment appointment){
        List <Appointment> appointments = service.findAllAppointments();
        model.addAttribute("appointments",appointments);
        return "all-appointments";
    }

}
