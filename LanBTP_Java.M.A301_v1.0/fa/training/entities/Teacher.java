package fa.training.entities;

public class Teacher extends Person {
    private double basicSalary;
    private double subsidy;

    public Teacher(String fullName, String gender, String phone, String email, java.util.Date birthDate, double basicSalary, double subsidy) {
        super(fullName, gender, phone, email, birthDate);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public double calculateSalary() {
        return basicSalary + subsidy;
    }

    @Override
    public void purchaseParkingPass() {
        // Implementation here
    }

    // Getters and setters
    // ...
}
