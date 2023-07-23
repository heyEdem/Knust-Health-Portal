package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return service.findAllAppointments();

    }


    @PostMapping("/addBooking")
    public Appointment addNewAppointment(Appointment appointment) {
        return service.createAppointment(appointment);
    }

//    @PutMapping
//    @RequestMapping({"/api/edit", "/api/edit{id}"})
//    public String editAppointment(Model model, @PathVariable("id") Optional<UUID> id) {
//        if (id.isPresent()) {
//            Optional<Appointment> appointment = service.findAppointmentById(id.get());
//
//            if (appointment.isPresent()) {
//                model.addAttribute("appointment", appointment);
//            } else {
//                model.addAttribute("appointment", new Appointment(id));
//            }
//        }
//        return "booking";
//    }

    @DeleteMapping("/api/delete/{id}")
    public String deleteAppointment(@PathVariable("id") UUID id){
        service.deleteAppointment(id);
        return "redirect:/";
    }
}
