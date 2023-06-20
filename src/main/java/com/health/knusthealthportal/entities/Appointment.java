package com.health.knusthealthportal.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Table(name="appointments")
@Builder
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    private String description;

    private LocalDate date;

    private LocalTime time;

}
