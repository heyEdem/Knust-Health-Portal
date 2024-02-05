package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Exception.ResourceNotFoundException;
import com.health.knusthealthportal.Repository.AppointmentRepository;
import com.health.knusthealthportal.entities.Appointment;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    final AppointmentRepository repository;
    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Appointment> findAllAppointments() {
        return repository.findAll();
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public void updateAppointment( Appointment appointment) {
u        Appointment result =  repository.findById(appointment.getId()).orElseThrow(()-> new EntityNotFoundException("Could not find appointment"));
        if (result != null){
            if (appointment.getStudentName() != null) result.setStudentName(appointment.getStudentName());
            if (appointment.getDescription() != null) result.setDescription(appointment.getDescription());
            if (appointment.getDate() != null)        result.setDate(appointment.getDate());
            if (appointment.getTime() != null)        result.setTime(appointment.getTime());
        }

//        Appointment appointment1 = null;
//        if (result.isPresent()){
//            appointment1 = result.get();
//            appointment1.setStudentName(appointment.getStudentName());
//            appointment1.setDescription(appointment.getDescription());
//            appointment1.setTime(appointment.getTime());
//            appointment1.setDate(appointment.getDate());
//            repository.save(appointment1);
//        }
    }

    @Override
    public void deleteAppointment(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Appointment> findAppointmentById(UUID id) {
       return repository.findById(id);
    }
}
