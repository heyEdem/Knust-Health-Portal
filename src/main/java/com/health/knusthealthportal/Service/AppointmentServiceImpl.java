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
    public void updateAppointment( UUID id) {
        Optional<Appointment> appointment = repository.findById(id);
        if (appointment.isPresent()){
            Appointment updatedAppointment = appointment.get();
            updatedAppointment.setStudentName("");
            updatedAppointment.setDescription("");
//            updatedAppointment.setDate(2023-05-05);
//            updatedAppointment.setTime(22:00);
            repository.save(updatedAppointment);
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
