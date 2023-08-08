package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Repository.AppointmentRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
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
        Appointment result =  repository.findById(appointment.getId()).orElseThrow(
                ()->new ChangeSetPersister.NotFoundException("Appointment not found"));
        Appointment appointment1 = null;
            result.setStudentName(appointment.getStudentName());
            result.setDescription(appointment.getDescription());
            result.setTime(appointment.getTime());
            result.setDate(appointment.getDate());
            repository.save(result);
        }
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
