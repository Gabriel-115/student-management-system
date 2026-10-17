import java.util.Scanner;

public class StudentManagement {
    // Class-level arrays to hold student data
    static String[] names;
    static String[] regNumbers;
    static String[] subjects;
    static String[] studentClasses;
    static double[] marks;
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Prime High School Management System ===");
        if (login()) {
            registerStudents();
            recordMarks();
            viewAllStudentsAndMarks();
        } else {
            System.out.println("Access Denied: Invalid credentials.");
        }
    }

    // 1. Login Method
    public static boolean login() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        return username.equals("teacher") && password.equals("1234");
    }

    // 2. Register Students Method (Dynamic Array Allocation)
    public static void registerStudents() {
        System.out.print("\nHow many students do you want to register? ");
        int totalStudents = sc.nextInt();
        sc.nextLine(); // Clear newline buffer

        // Dynamically size arrays to avoid ArrayIndexOutOfBoundsException
        names = new String[totalStudents];
        regNumbers = new String[totalStudents];
        subjects = new String[totalStudents];
        studentClasses = new String[totalStudents];
        marks = new double[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\nRegistering Student " + (i + 1) + " of " + totalStudents + ":");
            System.out.print("Enter Name: ");
            names[i] = sc.nextLine();
            System.out.print("Enter Registration Number: ");
            regNumbers[i] = sc.nextLine();
            System.out.print("Enter Subject: ");
            subjects[i] = sc.nextLine();
            System.out.print("Enter Class: ");
            studentClasses[i] = sc.nextLine();
        }
    }

    // 3. Record Marks Method
    public static void recordMarks() {
        System.out.println("\n--- Recording Student Marks ---");
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter marks for " + names[i] + " (" + regNumbers[i] + "): ");
            marks[i] = sc.nextDouble();
        }
        sc.nextLine(); // Clear trailing newline buffer
    }

    // 4. View Registered Students and Marks Method
    public static void viewAllStudentsAndMarks() {
        System.out.println("\n==========================================================");
        System.out.printf("%-15s %-12s %-10s %-10s %-5s\n", "REG NO", "NAME", "SUBJECT", "CLASS", "MARK");
        System.out.println("==========================================================");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-15s %-12s %-10s %-10s %-5.1f\n", 
                regNumbers[i], names[i], subjects[i], studentClasses[i], marks[i]);
        }
        System.out.println("==========================================================");
    }
}
