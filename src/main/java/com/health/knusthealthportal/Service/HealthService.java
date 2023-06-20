package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Repository.HealthRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {
    private final HealthRepository healthRepository;

    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public List<Appointment> findAll() {
        return healthRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        return healthRepository.save(appointment);
    }

    public void update(Appointment appointment) {
        healthRepository.save(appointment);
    }

    public void delete(Long id) {
        healthRepository.deleteById(id);
    }

}


