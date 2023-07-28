package com.health.knusthealthportal.Service;

import com.health.knusthealthportal.entities.Appointment;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {

    List<Appointment> findAllAppointments();

    Appointment createAppointment(Appointment appointment);

    void updateAppointment(UUID id);

    void deleteAppointment(UUID id);

    Optional<Appointment> findAppointmentById(UUID id);

}
