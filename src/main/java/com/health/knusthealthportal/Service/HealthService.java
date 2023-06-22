package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Repository.HealthRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {

    private HealthRepository repository;
    public HealthService(HealthRepository repository) {
        this.repository = repository;
    }

    public void add (Appointment appointment){
        repository.save(appointment);
    }

    public List<Appointment> findAppointments (){
        return repository.findAll();
    }

    public Appointment update (Appointment appointment){
        return repository.save(appointment);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }
}
