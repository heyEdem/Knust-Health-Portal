package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.health.knusthealthportal.entities.Appointment;

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
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String getAccount(Model model, Appointment appointment) {
         List <Appointment> appointments = service.findAllAppointments();
        System.out.println(appointments);
        model.addAttribute("appointments",appointments);
        return "confirmation-page";
    }


    @RequestMapping("/update/{id}")
    public String update (@PathVariable("id") UUID id , @RequestBody Appointment appointment){
         service.updateAppointment(appointment);
         return"booking";
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

    @PutMapping
    @RequestMapping({"/edit","edit/{id}"})
    public String editAppointment (Model model, @PathVariable("id") Optional<UUID> id){
        if (id.isPresent()) {
            Optional <Appointment> appointment = service.findAppointmentById(id.get());
            service.updateAppointment(appointment.get());
//            if (appointment.isPresent()) {
//                model.addAttribute("appointment", appointment);
//            }
//            else{
//                model.addAttribute("appointment", new Appointment());
//            }
                            model.addAttribute("appointment", appointment);

        }
        return "booking";
    }


}
