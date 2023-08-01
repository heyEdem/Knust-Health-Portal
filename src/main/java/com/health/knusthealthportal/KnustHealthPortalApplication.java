package com.health.knusthealthportal;
import com.health.knusthealthportal.Repository.UserRepository;
import com.health.knusthealthportal.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

import static com.health.knusthealthportal.Roles.*;

@SpringBootApplication
public class KnustHealthPortalApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public KnustHealthPortalApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(KnustHealthPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User s1 = new User();
        s1.setId(UUID.randomUUID());
        s1.setUsername("abdul");
        s1.setPassword("123");
        s1.setRole(STUDENT);

        User s2 = new User();
        s2.setId(UUID.randomUUID());
        s1.setUsername("edem");
        s2.setPassword("123");
        s2.setRole(ADMIN);

        User s3 = new User();
        s3.setId(UUID.randomUUID());
        s3.setUsername("enchil");
        s3.setPassword("123");

        User s4 = new User();
        s4.setId(UUID.randomUUID());
        s4.setUsername("prince");
        s4.setPassword("123");
        s1.setRole(DOCTOR);

        User s5 = new User();
        s5.setId(UUID.randomUUID());
        s5.setUsername("robert");
        s5.setPassword("123");
        s1.setRole(STUDENT);

        this.userRepository.save(s1);
        this.userRepository.save(s2);
        this.userRepository.save(s3);
        this.userRepository.save(s4);
        this.userRepository.save(s5);

    }
}
