import java.util.Scanner;

class InvalidMarksException extends Exception {
    InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Invalid marks! Marks must be between 0 and 100.");
            }

            System.out.println("Student Name: " + name);
            System.out.println("Marks: " + marks);

        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter marks as a number.");

        } finally {
            System.out.println("Marks validation is completed.");
        }

        sc.close();
    }
}
