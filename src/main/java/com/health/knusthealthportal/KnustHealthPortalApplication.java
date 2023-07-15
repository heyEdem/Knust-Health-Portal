package com.health.knusthealthportal;


import com.health.knusthealthportal.Service.AppointmentServiceImpl;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KnustHealthPortalApplication implements ApplicationRunner{

    public static void main(String[] args) {
        SpringApplication.run(KnustHealthPortalApplication.class, args);
    }


    private AppointmentServiceImpl service;
    public KnustHealthPortalApplication(AppointmentServiceImpl service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        List <Appointment> appointments = service.findAllAppointments();

        Appointment app1 = Appointment.builder().studentName("Edem").description("Headache").build();

        service.createAppointment(app1);
    }
}
