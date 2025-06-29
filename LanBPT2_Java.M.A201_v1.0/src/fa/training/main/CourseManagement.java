package fa.training.main;

import fa.training.entities.Course;
import fa.training.utils.Validator;
import java.util.Scanner;

public class CourseManagement {
    private static final int COURSE_COUNT = 10;
    private static Course[] courses = new Course[COURSE_COUNT];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int courseIndex = 0;
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. View all courses");
            System.out.println("2. Add course");
            System.out.println("3. Search course");
            System.out.println("4. Display mandatory courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    showAllCourses();
                    break;
                case "2":
                    while (courseIndex < COURSE_COUNT) {
                        System.out.println("Enter information for course " + (courseIndex + 1) + ":");
                        courses[courseIndex] = inputCourse(scanner);
                        courseIndex++;
                        if (courseIndex >= COURSE_COUNT) {
                            System.out.println("Maximum number of courses reached.");
                            break;
                        }
                        System.out.print("Do you want to add another course? (y/n): ");
                        String ans = scanner.nextLine();
                        if (ans.equalsIgnoreCase("n")) break;
                    }
                    break;
                case "3":
                    System.out.print("Enter attribute name (courseId, courseName, duration, status, flag): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter value to search: ");
                    String value = scanner.nextLine();
                    find(type, value);
                    break;
                case "4":
                    displayMandatoryCourses();
                    break;
                case "5":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Course inputCourse(Scanner scanner) {
        Course course = new Course();
        // Course code
        while (true) {
            System.out.print("Enter course code (FWxxx): ");
            String code = scanner.nextLine();
            if (Validator.isValidCourseCode(code)) {
                course.setCourseId(code);
                break;
            } else {
                System.out.println("Invalid course code. Try again.");
            }
        }
        // Course name
        System.out.print("Enter course name: ");
        course.setCourseName(scanner.nextLine());
        // Duration
        while (true) {
            System.out.print("Enter duration: ");
            try {
                double duration = Double.parseDouble(scanner.nextLine());
                course.setDuration(duration);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid duration. Try again.");
            }
        }
        // Status
        while (true) {
            System.out.print("Enter status (active/in-active): ");
            String status = scanner.nextLine();
            if (Validator.isValidStatus(status)) {
                course.setStatus(status);
                break;
            } else {
                System.out.println("Invalid status. Try again.");
            }
        }
        // Flag
        while (true) {
            System.out.print("Enter flag (optional/mandatory/N/A): ");
            String flag = scanner.nextLine();
            if (Validator.isValidFlag(flag)) {
                course.setFlag(flag);
                break;
            } else {
                System.out.println("Invalid flag. Try again.");
            }
        }
        return course;
    }

    // Search method
    public static void find(String type, Object data) {
        boolean found = false;
        for (Course c : courses) {
            if (c == null) continue;
            switch (type) {
                case "courseId":
                    if (c.getCourseId().equals(data)) found = printCourse(c);
                    break;
                case "courseName":
                    if (c.getCourseName().equals(data)) found = printCourse(c);
                    break;
                case "duration":
                    try {
                        double d = Double.parseDouble(data.toString());
                        if (c.getDuration() == d) found = printCourse(c);
                    } catch (NumberFormatException ignored) {}
                    break;
                case "status":
                    if (c.getStatus().equalsIgnoreCase(data.toString())) found = printCourse(c);
                    break;
                case "flag":
                    if (c.getFlag().equalsIgnoreCase(data.toString())) found = printCourse(c);
                    break;
                default:
                    System.out.println("Invalid attribute name.");
                    return;
            }
        }
        if (!found) System.out.println("No course found.");
    }

    private static boolean printCourse(Course c) {
        System.out.println(c);
        return true;
    }

    // Display all courses with flag "mandatory"
    public static void displayMandatoryCourses() {
        boolean found = false;
        for (Course c : courses) {
            if (c != null && "mandatory".equalsIgnoreCase(c.getFlag())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No mandatory courses found.");
    }

    private static void showAllCourses() {
        boolean found = false;
        for (Course c : courses) {
            if (c != null) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No courses available.");
    }
}
