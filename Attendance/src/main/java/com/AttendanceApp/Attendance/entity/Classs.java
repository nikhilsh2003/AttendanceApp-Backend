package com.AttendanceApp.Attendance.entity;

import com.AttendanceApp.Attendance.dto.ClasssDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Class")
public class Classs {
    @Id
    @Column(name = "Class_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;
    @Column(name = "Standard")
    private Integer standard;
    @Column(name = "Section")
    private Character section;
    @Column(name = "Strength")
    private Integer strength;

    public ClasssDto toDto() {
        ClasssDto classsDto = new ClasssDto();
        classsDto.setClassId(this.getClassId());
        classsDto.setStandard(this.getStandard());
        classsDto.setSection(this.getSection());
        classsDto.setStrength(this.getStrength());
        return classsDto;
    }
}
