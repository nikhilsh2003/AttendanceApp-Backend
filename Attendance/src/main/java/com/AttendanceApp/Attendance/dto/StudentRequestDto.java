package com.AttendanceApp.Attendance.dto;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private String emailId;
    private String hashedPassword;
    private Integer standard;
    private Character section;
}
