package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.health.knusthealthportal.entities.Appointment;

import java.util.List;

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

    @PostMapping("/login")
    public String Login(Model model) {
        return "redirect:/";
    }

    @GetMapping("/appointmentForm")
    public String showForm(Model model, Appointment appointment){
        return "booking";
    }

    @PostMapping("/appointmentForm")
    public String create (Model model, Appointment appointment) {
        if (appointment.getDate() != null && appointment.getDescription() != null && appointment.getStudentName() != null) {
            model.addAttribute("successMessage", "Your appointment has been successfully scheduled ");
        }
        Appointment result = service.createAppointment(appointment);
        return "redirect:/my-appointment";
    }

    @GetMapping("/my-appointment")
    public String getAccount(Model model, Appointment appointment) {
         List <Appointment> appointments = service.findAllAppointments();
        System.out.println(appointments);
        model.addAttribute("appointments",appointments);
        return "appointment-details";
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
