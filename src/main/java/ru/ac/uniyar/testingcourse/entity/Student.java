package ru.ac.uniyar.testingcourse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<WaitingList> waitingList = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<WaitingList> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<WaitingList> waitingList) {
        this.waitingList = waitingList;
    }
}
