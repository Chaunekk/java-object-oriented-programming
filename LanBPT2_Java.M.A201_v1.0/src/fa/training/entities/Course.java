package fa.training.entities;

import java.util.Scanner;

public class Course {
    private String courseId;
    private String courseName;
    private double duration;
    private String status;
    private String flag;

    // No-argument constructor
    public Course() {
        this.courseId = null;
        this.courseName = null;
        this.duration = 0.0;
        this.status = null;
        this.flag = null;
    }

    // Constructor with arguments
    public Course(String courseId, String courseName, double duration, String status, String flag) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.status = status;
        this.flag = flag;
    }

    // Getters and Setters
    public String getCourseId() { 
        return courseId; 
    }
    public void setCourseId(String courseId) { 
        this.courseId = courseId;
    }
    public String getCourseName() { 
        return courseName; 
    }
    public void setCourseName(String courseName) { 
        this.courseName = courseName; 
    }
    public double getDuration() { 
        return duration; 
    }
    public void setDuration(double duration) { 
        this.duration = duration; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public String getFlag() { 
        return flag; 
    }
    public void setFlag(String flag) { 
        this.flag = flag; }

    // toString override
    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    // Input method (validation will be handled in CourseManagement)
    public void input(Scanner scanner) {
        System.out.print("Enter course code: ");
        this.courseId = scanner.nextLine();
        System.out.print("Enter course name: ");
        this.courseName = scanner.nextLine();
        System.out.print("Enter duration: ");
        this.duration = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter status: ");
        this.status = scanner.nextLine();
        System.out.print("Enter flag: ");
        this.flag = scanner.nextLine();
    }
}
