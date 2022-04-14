package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "students")

public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(name = "studentFirstName")
    private String firstName;
@Column(name = "studentLastName")
    private String lastName;
    private String email;

    //this field will not be saved to the table
    @Transient
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
