package com.health.knusthealthportal.Controller;

import com.health.knusthealthportal.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        service.findAllAppointments();
        return "signup";
    }

    @GetMapping("/appointmentForm")
    public String showForm(Model model){
        model.addAttribute("appointment",new Appointment());
        return "booking";
    }
    @PostMapping("/add")
    public String create ( Model model, @Validated Appointment appointment, BindingResult bindingResult){
        service.createAppointment(appointment);
        List <Appointment> result = service.findAllAppointments();
        model.addAttribute("appointments", result);
        return "booking";
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
