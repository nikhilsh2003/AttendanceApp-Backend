package com.AttendanceApp.Attendance.repository;

import com.AttendanceApp.Attendance.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByEmailId(String teacherEmailId);
}
