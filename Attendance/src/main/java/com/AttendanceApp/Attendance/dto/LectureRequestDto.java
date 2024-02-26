package com.AttendanceApp.Attendance.dto;

import lombok.Data;

@Data
public class LectureRequestDto {
    private Integer standard;
    private Character section;
    private String courseName;
    private String teacherEmailId;
    private String date;
    private String lecturePassword;
}
