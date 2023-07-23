package com.health.knusthealthportal.entities;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @NotNull
    private  UUID id = UUID.randomUUID();

    private String studentName;

    private String description;

    private Date date;




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
