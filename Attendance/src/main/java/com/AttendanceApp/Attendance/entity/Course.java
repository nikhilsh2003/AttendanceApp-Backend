package com.AttendanceApp.Attendance.entity;

import com.AttendanceApp.Attendance.dto.CourseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_Id")
    private Long courseId;
    @Column(name = "Course_Name")
    private String courseName;
    @Column(name = "Standard")
    private Integer standard;

    public CourseDto toDto() {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(this.getCourseId());
        courseDto.setCourseName(this.getCourseName());
        courseDto.setStandard(this.getStandard());
        return courseDto;
    }
}
