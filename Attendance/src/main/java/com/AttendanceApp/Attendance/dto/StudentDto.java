package com.AttendanceApp.Attendance.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long studentId;
    private String name;
    private String emailId;
    private String hashedPassword;
    private ClasssDto classs;
}
