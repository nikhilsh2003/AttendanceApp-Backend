package com.AttendanceApp.Attendance.entity;

import com.AttendanceApp.Attendance.dto.LectureDto;
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
@Table(name = "Lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Lecture_Id")
    private Long lectureId;
    @ManyToOne
    @JoinColumn(name = "Course_Id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "Teacher_Id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "Class_Id")
    private Classs classs;
    @Column(name = "Lecture_Date")
    private String lectureDate;
    @Column(name = "Lecture_Password")
    private String lecturePassword;

    public LectureDto toDto() {
        LectureDto lectureDto = new LectureDto();
        lectureDto.setLectureId(this.getLectureId());
        lectureDto.setCourse(this.getCourse().toDto());
        lectureDto.setTeacher(this.getTeacher().toDto());
        lectureDto.setClasss(this.getClasss().toDto());
        lectureDto.setLectureDate(this.getLectureDate());
        lectureDto.setLecturePassword(this.getLecturePassword());
        return lectureDto;
    }
}
