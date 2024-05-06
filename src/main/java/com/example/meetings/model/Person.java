package com.example.meetings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="persons")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString(){
        return "firstName:" + firstName + ", lastName:" + lastName + ", gender:" + gender + ", age:" + age;
    }
}
