package com.AttendanceApp.Attendance.dto;

import lombok.Data;

@Data
public class LectureDto {
    private Long lectureId;
    private CourseDto course;
    private TeacherDto teacher;
    private ClasssDto classs;
    private String lectureDate;
    private String lecturePassword;
}
