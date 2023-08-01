package com.health.knusthealthportal;
import com.health.knusthealthportal.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class KnustHealthPortalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KnustHealthPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setId(UUID.randomUUID());
        s1.setPassword("123");
        s1.setUsername("abdul");

        Student s2 = new Student();
        s2.setId(UUID.randomUUID());
        s2.setPassword("123");
        s1.setUsername("edem");

        Student s3 = new Student();
        s3.setId(UUID.randomUUID());
        s3.setPassword("123");
        s3.setUsername("enchil");

        Student s4 = new Student();
        s4.setId(UUID.randomUUID());
        s4.setPassword("123");
        s4.setUsername("prince");

        Student s5 = new Student();
        s5.setId(UUID.randomUUID());
        s5.setPassword("123");
        s5.setUsername("robert");
    }
}
