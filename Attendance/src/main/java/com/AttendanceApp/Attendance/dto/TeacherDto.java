package com.AttendanceApp.Attendance.dto;

import lombok.Data;

@Data
public class TeacherDto {
    private Long teacherId;
    private String name;
    private String emailId;
    private String hashedPassword;
}
