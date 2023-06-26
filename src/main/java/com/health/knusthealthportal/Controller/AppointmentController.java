//package com.health.knusthealthportal.Controller;
//
//import com.health.knusthealthportal.Service.AppointmentService;
//import com.health.knusthealthportal.entities.Appointment;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//public class AppointmentController {
//    private final AppointmentService service;
//
//    public AppointmentController(AppointmentService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/")
//    public String getAllAppointments(Model model) {
//        List<Appointment> appointments = service.findAllAppointments();
//        model.addAttribute("appointments", appointments);
//        return "index";
//    }
//
//    @GetMapping("/addBooking")
//    public String postNewAppointment(Appointment appointment) {
//        return "booking";
//    }
//
//    @PostMapping("/addBooking")
//    public String addNewAppointment(Appointment appointment) {
//        Appointment newAppointment = service.createAppointment(appointment);
//        return "redirect:/";
//    }
//
//    @PutMapping
//    @RequestMapping({"/edit", "/edit{id}"})
//    public String editAppointment(Model model, @PathVariable("id") Optional<Long> id) {
//        if (id.isPresent()) {
//            Optional<Appointment> appointment = service.findAppointmentById(id.get());
//
//            if (appointment.isPresent()) {
//                model.addAttribute("appointment", appointment);
//            } else {
//                model.addAttribute("appointment", new Appointment());
//            }
//        }
//        return "booking";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteAppointment(@PathVariable("id") Long id){
//        service.deleteAppointment(id);
//        return "redirect:/";
//    }
//}
