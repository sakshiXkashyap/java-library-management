package model;

public class Student {

    private int studentId;
    private String name;
    private String course;

    // Constructor
    public Student(int studentId, String name, String course) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    // Get Student ID
    public int getStudentId() {
        return studentId;
    }

    // Get Student Name
    public String getName() {
        return name;
    }

    // Get Course
    public String getCourse() {
        return course;
    }

    // Display Student
    public void displayStudent() {

        System.out.println("----------------------------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
    }
}