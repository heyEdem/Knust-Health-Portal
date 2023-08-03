package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.health.knusthealthportal.entities.Appointment;
import java.util.List;
import java.util.UUID;


@Controller
public class AppointmentRestController {

   private final AppointmentService service;

    public AppointmentRestController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/app")
    public String home (Model model){
        return "index";
    }

    @GetMapping("/app/find")
    public String find (Model model){
        return "find-drug";
    }
    @GetMapping("/app/account")
    public String getAccount(Model model){
        return "profile";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/app/appointmentForm")
    public String showForm(Model model, Appointment appointment){
        return "doc-booking";
    }

    @PostMapping("/app/appointmentForm")
    public String create (Model model, Appointment appointment) {
        Appointment result = service.createAppointment(appointment);
        return "redirect:/app/confirmation";
    }

    @GetMapping("/app/confirmation")
    public String getAccount(Model model, Appointment appointment) {
         List <Appointment> appointments = service.findAllAppointments();
        System.out.println(appointments);
        model.addAttribute("appointments",appointments);
        return "confirmation-page";
    }

//    @PutMapping

   @PostMapping("/app/editAppointment")
    public String update(@ModelAttribute Appointment appointment){
         service.updateAppointment(appointment);
         return "redirect:/app/app/all-appointments";
    }

    @GetMapping("/app/editAppointment/{id}")
    public String editAppointmentForm(@PathVariable("id") UUID id, Model model){
        model.addAttribute("appointment",service.findAppointmentById(id));
        return "doc-update";
    }


    @RequestMapping("/app/delete/{id}")
        public String delete(@PathVariable("id") UUID id){
        service.deleteAppointment(id);
        return "redirect:/app/all-appointments";
    }
    @GetMapping("/app/all-appointments")
    public String allAppointments(Model model, Appointment appointment){
        List <Appointment> appointments = service.findAllAppointments();
        model.addAttribute("appointments",appointments);
        return "all-appointments";
    }

}
