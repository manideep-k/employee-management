package com.sample.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private int age;

    private String address;

    @Column(nullable = false)
    @Convert(converter = EmployeeAttributeConverter.class)
    private EmployeeRole role;

    @JsonIgnore
    private String user_name;

    @JsonIgnore
    private String password;

    @Column(columnDefinition="DATETIME(3)")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(columnDefinition="DATETIME(3)")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

}

