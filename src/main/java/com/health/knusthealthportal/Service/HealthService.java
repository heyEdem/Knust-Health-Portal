package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Repository.HealthRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {
    private HealthRepository healthRepository;

    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public List<Appointment> findAllAppointments (Appointment appointment){
        return healthRepository.findAll();
    }

    public Appointment createAppointment (Appointment appointment){
        return healthRepository.save(appointment);
    }

    public void update (Appointment appointment){
         healthRepository.save(appointment);
    }
    public void delete (Appointment appointment){
        healthRepository.delete(appointment);
    }

}
