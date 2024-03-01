package com.AttendanceApp.Attendance.repository;

import com.AttendanceApp.Attendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmailId(String emailId);
}
