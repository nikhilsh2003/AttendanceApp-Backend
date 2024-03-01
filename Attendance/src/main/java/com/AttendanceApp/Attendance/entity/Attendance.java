package com.AttendanceApp.Attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Attendance")
public class Attendance {
    @Id
    @Column(name = "Attendance_Id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Lecture_Id")
    private Lecture lectureId;
    @ManyToOne
    @JoinColumn(name = "Student_Id")
    private Student studentId;
    @Column(name = "Status")
    private Character status;
}
