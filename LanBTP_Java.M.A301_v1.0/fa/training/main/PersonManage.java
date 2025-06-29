package fa.training.main;

import fa.training.entities.*;
import fa.training.utils.Validator;
import java.util.*;

public class PersonManage {
    private static final int MAX_PERSON = 10;
    private static Person[] people = new Person[MAX_PERSON];
    private static int count = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Input data");
            System.out.println("2. Update student");
            System.out.println("3. Display teachers with salary > 1000$");
            System.out.println("4. Report students who pass");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: inputData(); break;
                case 2: updateStudent(); break;
                case 3: displayTeachers(); break;
                case 4: reportStudents(); break;
                case 5: return;
                default: System.out.println("Invalid!");
            }
        }
    }

    private static void inputData() {
        int i = count;
        while (i < MAX_PERSON) {
            System.out.print("Enter type (1-Student, 2-Teacher): ");
            int type = Integer.parseInt(sc.nextLine());
            if (type == 1) {
                people[i] = createStudent();
            } else if (type == 2) {
                people[i] = createTeacher();
            } else {
                System.out.println("Invalid type!");
                continue;
            }
            count++;
            i++;
            System.out.print("Do you want to add another person? (y/n): ");
            String ans = sc.nextLine();
            if (!ans.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private static Student createStudent() {
        System.out.print("Full name: ");
        String fullName = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        String phone;
        do {
            System.out.print("Phone (10 digits): ");
            phone = sc.nextLine();
            if (!Validator.isValidPhone(phone)) System.out.println("Invalid phone number!");
        } while (!Validator.isValidPhone(phone));
        String email;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (!Validator.isValidEmail(email)) System.out.println("Invalid email!");
        } while (!Validator.isValidEmail(email));
        Date birthDate;
        do {
            System.out.print("Birth date (dd/MM/yyyy): ");
            birthDate = Validator.parseDate(sc.nextLine());
            if (birthDate == null) System.out.println("Invalid date!");
        } while (birthDate == null);
        System.out.print("Student ID: ");
        String studentId = sc.nextLine();
        double theory, practice;
        do {
            System.out.print("Theory (0-10): ");
            theory = Double.parseDouble(sc.nextLine());
            if (!Validator.isValidMark(theory)) System.out.println("Invalid mark!");
        } while (!Validator.isValidMark(theory));
        do {
            System.out.print("Practice (0-10): ");
            practice = Double.parseDouble(sc.nextLine());
            if (!Validator.isValidMark(practice)) System.out.println("Invalid mark!");
        } while (!Validator.isValidMark(practice));
        return new Student(fullName, gender, phone, email, birthDate, studentId, theory, practice);
    }

    private static Teacher createTeacher() {
        System.out.print("Full name: ");
        String fullName = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        String phone;
        do {
            System.out.print("Phone (10 digits): ");
            phone = sc.nextLine();
            if (!Validator.isValidPhone(phone)) System.out.println("Invalid phone number!");
        } while (!Validator.isValidPhone(phone));
        String email;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (!Validator.isValidEmail(email)) System.out.println("Invalid email!");
        } while (!Validator.isValidEmail(email));
        Date birthDate;
        do {
            System.out.print("Birth date (dd/MM/yyyy): ");
            birthDate = Validator.parseDate(sc.nextLine());
            if (birthDate == null) System.out.println("Invalid date!");
        } while (birthDate == null);
        double basicSalary, subsidy;
        System.out.print("Basic salary: ");
        basicSalary = Double.parseDouble(sc.nextLine());
        System.out.print("Subsidy: ");
        subsidy = Double.parseDouble(sc.nextLine());
        return new Teacher(fullName, gender, phone, email, birthDate, basicSalary, subsidy);
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String id = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (people[i] instanceof Student) {
                Student s = (Student) people[i];
                if (s.getStudentId().equals(id)) {
                    System.out.println("Updating info for student " + id);
                    people[i] = createStudent();
                    return;
                }
            }
        }
        System.out.println("Student not found!");
    }

    private static void displayTeachers() {
        for (int i = 0; i < count; i++) {
            if (people[i] instanceof Teacher) {
                Teacher t = (Teacher) people[i];
                if (t.calculateSalary() > 1000) {
                    System.out.println("Teacher: " + t.getFullName() + ", Salary: " + t.calculateSalary());
                }
            }
        }
    }

    private static void reportStudents() {
        for (int i = 0; i < count; i++) {
            if (people[i] instanceof Student) {
                Student s = (Student) people[i];
                double mark = s.calculateFinalMark();
                if (mark >= 6) {
                    System.out.println("Student: " + s.getFullName() + ", Final Mark: " + mark);
                }
            }
        }
    }
}
