package com.AttendanceApp.Attendance.entity;

import com.AttendanceApp.Attendance.dto.StudentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_Id")
    private Long studentId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email_ID")
    private String emailId;
    @Column(name = "Hashed_Password")
    private String hashedPassword;
    @ManyToOne
    @JoinColumn(name = "Class_Id")
    private Classs classs;

    public StudentDto toDto() {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(this.getStudentId());
        studentDto.setName(this.getName());
        studentDto.setEmailId(this.getEmailId());
        studentDto.setHashedPassword(this.getHashedPassword());
        studentDto.setClasss(this.getClasss().toDto());
        return studentDto;
    }
}
