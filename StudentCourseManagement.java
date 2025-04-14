// Interface for calculating grade
interface Grading {
    String calculateGrade(double marks);
}

// Base class Person
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Student class extends Person
class Student extends Person implements Grading {
    String studentId;
    static int studentCount = 0;

    Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        studentCount++;
    }

    void displayStudentInfo() {
        super.displayPersonInfo();
        System.out.println("Student ID: " + studentId);
    }

    @Override
    public String calculateGrade(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    static void showTotalStudents() {
        System.out.println("Total Students: " + studentCount);
    }
}

// GraduateStudent class extends Student (Multilevel Inheritance)
class GraduateStudent extends Student {
    String specialization;

    GraduateStudent(String name, int age, String studentId, String specialization) {
        super(name, age, studentId);
        this.specialization = specialization;
    }

    void displayGraduateInfo() {
        displayStudentInfo();
        System.out.println("Specialization: " + specialization);
    }
}

// Course class
class Course {
    String courseId;
    String courseName;
    double marks;

    Course(String courseId, String courseName, double marks) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.marks = marks;
    }

    void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Marks: " + marks);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        GraduateStudent student1 = new GraduateStudent("Manisha", 22, "S101", "Computer Science");
        Course course1 = new Course("CSE101", "Java Programming", 88.5);

        System.out.println("--- Student Information ---");
        student1.displayGraduateInfo();
        System.out.println("--- Course Information ---");
        course1.displayCourseInfo();

        String grade = student1.calculateGrade(course1.marks);
        System.out.println("Grade: " + grade);

        Student.showTotalStudents();
    }
}
