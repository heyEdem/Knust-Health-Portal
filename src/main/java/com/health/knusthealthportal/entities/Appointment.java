package com.health.knusthealthportal.entities;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID appointmentId;

    private String studentName;

    private String description;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
