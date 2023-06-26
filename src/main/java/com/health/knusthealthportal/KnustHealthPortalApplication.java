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
public class KnustHealthPortalApplication{

    public static void main(String[] args) {
        SpringApplication.run(KnustHealthPortalApplication.class, args);
    }

}
