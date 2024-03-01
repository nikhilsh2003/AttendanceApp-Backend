package com.AttendanceApp.Attendance.repository;

import com.AttendanceApp.Attendance.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT C FROM Course C WHERE C.courseName = :courseName AND C.standard = :standard")
    Course findByCourseNameAndStandard(String courseName, Integer standard);
}
