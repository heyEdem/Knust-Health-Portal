package com.health.knusthealthportal;

import com.health.knusthealthportal.entities.Appointment;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class KnustHealthPortalApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(KnustHealthPortalApplication.class, args);
    }

    private HealthService healthService;

    public KnustHealthPortalApplication(HealthService healthService) {
        this.healthService = healthService;
    }

    @Override
    public void run (ApplicationArguments args) throws Exception {
        List<Appointment> appointments = healthService.findAppointments();

        if (appointments == null && appointments.isEmpty()) {
            Appointment app1 = Appointment.builder().studentName("Vera").description("Stomachache")
                    .date(LocalDate.now()).time(LocalTime.now()).build();

            Appointment app2 = Appointment.builder().studentName("Elvis").description("Headache")
                    .date(LocalDate.now()).time(LocalTime.now()).build();

            Arrays.asList(app1,app2).forEach(a -> healthService.add(a));
        }
    }
}
