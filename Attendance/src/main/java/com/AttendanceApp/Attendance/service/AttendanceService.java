package com.AttendanceApp.Attendance.service;

import com.AttendanceApp.Attendance.dto.ClasssDto;
import com.AttendanceApp.Attendance.dto.CourseDto;
import com.AttendanceApp.Attendance.dto.LectureDto;
import com.AttendanceApp.Attendance.dto.LectureRequestDto;
import com.AttendanceApp.Attendance.dto.StudentDto;
import com.AttendanceApp.Attendance.dto.StudentRequestDto;
import com.AttendanceApp.Attendance.dto.TeacherDto;
import com.AttendanceApp.Attendance.entity.Classs;
import com.AttendanceApp.Attendance.entity.Course;
import com.AttendanceApp.Attendance.entity.Lecture;
import com.AttendanceApp.Attendance.entity.Student;
import com.AttendanceApp.Attendance.entity.Teacher;
import com.AttendanceApp.Attendance.repository.AttendanceRepository;
import com.AttendanceApp.Attendance.repository.ClasssRepository;
import com.AttendanceApp.Attendance.repository.CourseRepository;
import com.AttendanceApp.Attendance.repository.LectureRepository;
import com.AttendanceApp.Attendance.repository.StudentRepository;
import com.AttendanceApp.Attendance.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;
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

    public ResponseEntity<StudentDto> saveStudent(StudentRequestDto requestDto, String randomUUID) {
        try {
            log.info("Adding student");
            Student presentStudent = studentRepository.findByEmailId(requestDto.getEmailId());
            if (!Objects.isNull(presentStudent)) {
                log.error("Student with EmailId : {} already exists.", presentStudent.getEmailId());
                return new ResponseEntity<>(presentStudent.toDto(), HttpStatus.BAD_REQUEST);
            }
            Student student = new Student();
            student.setName(requestDto.getName());
            student.setEmailId(requestDto.getEmailId());
            student.setHashedPassword(requestDto.getHashedPassword());
            Classs classs = classsRepository.findByStandardAndSection(requestDto.getStandard(), requestDto.getSection());
            student.setClasss(classs);
            Student savedStudent = studentRepository.save(student);
            return new ResponseEntity<>(savedStudent.toDto(), HttpStatus.CREATED);
        } catch (Exception e) {
            //noinspection LoggingPlaceholderCountMatchesArgumentCount
            log.error("Failed due to Exception : {}", e);
            return new ResponseEntity<>(new StudentDto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ClasssDto> saveClass(ClasssDto requestDto, String randomUUID) {
        try {
            log.info("Adding class");
            Classs presentClasss = classsRepository.findByStandardAndSection(requestDto.getStandard(), requestDto.getSection());
            if (!Objects.isNull(presentClasss)) {
                log.error("Class with standard : {} and section : {} exists.", requestDto.getStandard(), requestDto.getSection());
                return new ResponseEntity<>(presentClasss.toDto(), HttpStatus.BAD_REQUEST);
            }
            Classs classs = new Classs();
            classs.setStandard(requestDto.getStandard());
            classs.setSection(requestDto.getSection());
            classs.setStrength(requestDto.getStrength());
            Classs savedClasss = classsRepository.save(classs);
            requestDto.setClassId(savedClasss.getClassId());
            return new ResponseEntity<>(requestDto, HttpStatus.CREATED);
        } catch (Exception e) {
            //noinspection LoggingPlaceholderCountMatchesArgumentCount
            log.error("Failed due to Exception : {}", e);
            return new ResponseEntity<>(new ClasssDto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CourseDto> saveCourse(CourseDto requestDto, String randomUUID) {
        try {
            log.info("Adding Course");
            Course presentCourse = courseRepository.findByCourseNameAndStandard(requestDto.getCourseName(), requestDto.getStandard());
            if (!Objects.isNull(presentCourse)) {
                log.error("Course with Course Name : {}, Standard : {} already exists.", presentCourse.getCourseName(), presentCourse.getStandard());
                return new ResponseEntity<>(presentCourse.toDto(), HttpStatus.BAD_REQUEST);
            }
            Course course = new Course();
            course.setCourseName(requestDto.getCourseName());
            course.setStandard(requestDto.getStandard());
            Course savedCourse = courseRepository.save(course);
            return new ResponseEntity<>(savedCourse.toDto(), HttpStatus.CREATED);
        } catch (Exception e) {
            //noinspection LoggingPlaceholderCountMatchesArgumentCount
            log.error("Failed due to Exception : {}", e);
            return new ResponseEntity<>(new CourseDto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<LectureDto> saveLecture(LectureRequestDto requestDto, String randomUUID) {
        try {
            log.info("Adding Lecture");
            Classs classs = classsRepository.findByStandardAndSection(requestDto.getStandard(), requestDto.getSection());
            Course course = courseRepository.findByCourseNameAndStandard(requestDto.getCourseName(), requestDto.getStandard());
            Teacher teacher = teacherRepository.findByEmailId(requestDto.getTeacherEmailId());
            Lecture lecture = new Lecture();
            lecture.setClasss(classs);
            lecture.setCourse(course);
            lecture.setTeacher(teacher);
            lecture.setLectureDate(requestDto.getDate());
            lecture.setLecturePassword(requestDto.getLecturePassword());
            Lecture savedLecture = lectureRepository.save(lecture);
            return new ResponseEntity<>(savedLecture.toDto(), HttpStatus.CREATED);
        } catch (Exception e) {
            //noinspection LoggingPlaceholderCountMatchesArgumentCount
            log.error("Failed due to Exception : {}", e);
            return new ResponseEntity<>(new LectureDto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<TeacherDto> saveTeacher(TeacherDto requestDto, String randomUUID) {
        try {
            log.info("Adding Lecture");
            Teacher presentTeacher=teacherRepository.findByEmailId(requestDto.getEmailId());
            if(!Objects.isNull(presentTeacher)) {
                log.error("Student with EmailId : {} already exists.", presentTeacher.getEmailId());
                return new ResponseEntity<>(presentTeacher.toDto(), HttpStatus.BAD_REQUEST);
            }
            Teacher teacher=new Teacher();
            teacher.setEmailId(requestDto.getEmailId());
            teacher.setName(requestDto.getName());
            teacher.setHashedPassword(requestDto.getHashedPassword());
            Teacher savedTeacher=teacherRepository.save(teacher);
            return new ResponseEntity<>(savedTeacher.toDto(),HttpStatus.CREATED);
        }
        catch (Exception e) {
            //noinspection LoggingPlaceholderCountMatchesArgumentCount
            log.error("Failed due to Exception : {}", e);
            return new ResponseEntity<>(new TeacherDto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
