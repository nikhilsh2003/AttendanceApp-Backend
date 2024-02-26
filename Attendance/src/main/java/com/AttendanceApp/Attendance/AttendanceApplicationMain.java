package com.AttendanceApp.Attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.AttendanceApp.Attendance.repository")
@SpringBootApplication
public class AttendanceApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplicationMain.class, args);
    }

}
