package ru.ac.uniyar.testingcourse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "max_students")
    private int maxStudents;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<WaitingList> waitingList = new ArrayList<>();

    public Course() {}

    public Course(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public List<Integer> getEnrollments() {
        List<Integer> enrollmentIds = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            enrollmentIds.add(enrollment.getStudent().getStudentId());
        }
        return Collections.unmodifiableList(enrollmentIds);
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Integer> getWaitingList() {
        List<Integer> waitingListIds = new ArrayList<>();
        for (WaitingList waiting : waitingList) {
            waitingListIds.add(waiting.getStudent().getStudentId());
        }
        return Collections.unmodifiableList(waitingListIds);
    }

    public void setWaitingList(List<WaitingList> waitingList) {
        this.waitingList = waitingList;
    }

    public boolean isFullyEnrolled() {
        return enrollments.size() == maxStudents;
    }

    public boolean hasWaitingList() {
        return !waitingList.isEmpty();
    }
}
