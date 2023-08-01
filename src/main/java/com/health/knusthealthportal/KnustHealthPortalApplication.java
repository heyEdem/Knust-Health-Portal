package com.health.knusthealthportal;
import com.health.knusthealthportal.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KnustHealthPortalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KnustHealthPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setPassword();
    }
}
