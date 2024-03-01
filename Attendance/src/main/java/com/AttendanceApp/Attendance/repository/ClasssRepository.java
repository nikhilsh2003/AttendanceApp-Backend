package com.AttendanceApp.Attendance.repository;

import com.AttendanceApp.Attendance.entity.Classs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasssRepository extends JpaRepository<Classs, Long> {
    @Query("SELECT CL FROM Classs CL where CL.standard = :standard AND CL.section = :section")
    Classs findByStandardAndSection(Integer standard, Character section);
}
