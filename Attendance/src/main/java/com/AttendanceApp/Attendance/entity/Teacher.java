package com.AttendanceApp.Attendance.entity;

import com.AttendanceApp.Attendance.dto.TeacherDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Teacher_Id")
    private Long teacherId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email_Id")
    private String emailId;
    @Column(name = "Hashed_Password")
    private String hashedPassword;

    public TeacherDto toDto() {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(this.getTeacherId());
        teacherDto.setName(this.getName());
        teacherDto.setEmailId(this.getEmailId());
        teacherDto.setHashedPassword(this.getHashedPassword());
        return teacherDto;
    }
}
