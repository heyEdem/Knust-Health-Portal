package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.Repository.AppointmentRepository;
import com.health.knusthealthportal.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    final AppointmentRepository repository;
    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }



    @Override
    public List<Appointment> findAllAppointments() {
        return null;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public void deleteAppointment(Long id) {

    }

    @Override
    public Optional<Appointment> findAppointmentById(Long id) {
        return Optional.empty();
    }

}
