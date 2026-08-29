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

    // Getter for Student ID
    public int getStudentId() {
        return studentId;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Course
    public String getCourse() {
        return course;
    }

    // Display student
    public void displayStudent() {

        System.out.println("----------------------------");

        System.out.println(
                "Student ID : " + studentId
        );

        System.out.println(
                "Name       : " + name
        );

        System.out.println(
                "Course     : " + course
        );
    }
}