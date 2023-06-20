package com.health.knusthealthportal.Repository;

import com.health.knusthealthportal.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<Appointment, Long> {
}
