package com.AttendanceApp.Attendance.controller;

import com.AttendanceApp.Attendance.dto.ClasssDto;
import com.AttendanceApp.Attendance.dto.CourseDto;
import com.AttendanceApp.Attendance.dto.LectureDto;
import com.AttendanceApp.Attendance.dto.LectureRequestDto;
import com.AttendanceApp.Attendance.dto.StudentDto;
import com.AttendanceApp.Attendance.dto.StudentRequestDto;
import com.AttendanceApp.Attendance.dto.TeacherDto;
import com.AttendanceApp.Attendance.entity.Teacher;
import com.AttendanceApp.Attendance.repository.AttendanceRepository;
import com.AttendanceApp.Attendance.repository.ClasssRepository;
import com.AttendanceApp.Attendance.repository.CourseRepository;
import com.AttendanceApp.Attendance.repository.LectureRepository;
import com.AttendanceApp.Attendance.repository.StudentRepository;
import com.AttendanceApp.Attendance.repository.TeacherRepository;
import com.AttendanceApp.Attendance.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(path = "/api")
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ClasssRepository classsRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(path = "/addStudent")
    @Operation(description = "Post api for saving student", tags = "Attendance APIs")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentRequestDto requestDto) {
        String randomUUID = UUID.randomUUID().toString();
        log.info("Saving Student : Request System Key : {}", randomUUID);
        return attendanceService.saveStudent(requestDto, randomUUID);
    }

    @PostMapping(path = "/addClass")
    @Operation(description = "Post api for saving class", tags = "Attendance APIs")
    public ResponseEntity<ClasssDto> addClass(@RequestBody ClasssDto requestDto) {
        String randomUUID = UUID.randomUUID().toString();
        log.info("Saving Class : Request System Key : {}", randomUUID);
        return attendanceService.saveClass(requestDto, randomUUID);
    }

    @PostMapping(path = "/addCourse")
    @Operation(description = "Post api for saving course", tags = "Attendance APIs")
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto requestDto) {
        String randomUUID = UUID.randomUUID().toString();
        log.info("Saving Course : Request System Key : {}", randomUUID);
        return attendanceService.saveCourse(requestDto, randomUUID);
    }

    @PostMapping(path = "/addLecture")
    @Operation(description = "Post api for adding Lecture", tags = "Attendance APIs")
    public ResponseEntity<LectureDto> addLecture(@RequestBody LectureRequestDto requestDto) {
        String randomUUID = UUID.randomUUID().toString();
        log.info("Saving Course : Request System Key : {}", randomUUID);
        return attendanceService.saveLecture(requestDto, randomUUID);
    }
    @PostMapping(path = "/addTeacher")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto requestDto) {
        String randomUUID = UUID.randomUUID().toString();
        log.info("Saving Student : Request System Key : {}", randomUUID);
        return attendanceService.saveTeacher(requestDto,randomUUID);
    }
}
