package ru.ac.uniyar.testingcourse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "waiting_list")
public class WaitingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waiting_list_id")
    private int waitingListId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public WaitingList() {
    }

    public WaitingList(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public int getWaitingListId() {
        return waitingListId;
    }

    public void setWaitingListId(int waitingListId) {
        this.waitingListId = waitingListId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
