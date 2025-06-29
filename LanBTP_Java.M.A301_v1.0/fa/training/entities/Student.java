package fa.training.entities;

public class Student extends Person {
    private String studentId;
    private double theory;
    private double practice;

    public Student(String fullName, String gender, String phone, String email, java.util.Date birthDate, String studentId, double theory, double practice) {
        super(fullName, gender, phone, email, birthDate);
        this.studentId = studentId;
        this.theory = theory;
        this.practice = practice;
    }

    public double calculateFinalMark() {
        return (theory + practice) / 2.0;
    }

    @Override
    public void purchaseParkingPass() {
        // Implementation here
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }
}
