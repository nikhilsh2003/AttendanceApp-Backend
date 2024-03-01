package com.AttendanceApp.Attendance.dto;

import lombok.Data;

@Data
public class AttendanceDto {
    private LectureDto lectureId;
    private StudentDto studentId;
    private Character status;
}
