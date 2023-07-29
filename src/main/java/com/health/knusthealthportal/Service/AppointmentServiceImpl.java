package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Repository.AppointmentRepository;
import com.health.knusthealthportal.entities.Appointment;
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
        Optional<Appointment> result =  repository.findById(appointment.getId());
        Appointment appointment1 = null;
        if (!result.isEmpty()){
            appointment1 = result.get();
            appointment1.setStudentName(appointment.getStudentName());
            appointment1.setDescription(appointment.getDescription());
            appointment1.setTime(appointment.getTime());
            appointment1.setDate(appointment.getDate());
            repository.save(appointment1);
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
