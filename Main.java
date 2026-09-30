import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Get student details
            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Marks: ");
            String marks = sc.nextLine();

            // Write student details to file
            FileWriter writer = new FileWriter("student.txt");

            writer.write("Student ID: " + id + "\n");
            writer.write("Student Name: " + name + "\n");
            writer.write("Department: " + department + "\n");
            writer.write("Marks: " + marks + "\n");

            writer.close();

            System.out.println("\nStudent record stored successfully.");

            // Read student details from file
            FileReader reader = new FileReader("student.txt");

            int ch;
            System.out.println("\nRetrieved Student Record:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        sc.close();
    }
}
