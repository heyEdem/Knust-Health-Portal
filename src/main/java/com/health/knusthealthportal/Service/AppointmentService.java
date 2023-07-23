package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.entities.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {

    List<Appointment> findAllAppointments();

    Appointment createAppointment(Appointment appointment);

    void updateAppointment(Appointment appointment);

    void deleteAppointment(Long id);

    Optional<Appointment> findAppointmentById(Long id);
}
