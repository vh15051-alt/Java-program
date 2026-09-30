import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class SalaryStreamDemo {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(101, "Ravi", 45000),
            new Employee(102, "Priya", 60000),
            new Employee(103, "Amit", 35000),
            new Employee(104, "Sneha", 75000),
            new Employee(105, "Kiran", 50000)
        );

        double salaryThreshold = 50000;

        // 1. Filter employees whose salary is above threshold
        System.out.println("Employees with salary above " + salaryThreshold + ":");

        List<Employee> filtered = employees.stream()
                .filter(e -> e.getSalary() > salaryThreshold)
                .collect(Collectors.toList());

        filtered.forEach(System.out::println);

        // 2. Sort salary in ascending order
        System.out.println("\nSalary in Ascending Order:");

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);

        // 3. Sort salary in descending order
        System.out.println("\nSalary in Descending Order:");

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // 4. Calculate average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Salary: " + averageSalary);

        // 5. Find maximum salary
        double maximumSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);

        System.out.println("Maximum Salary: " + maximumSalary);

        // 6. Find minimum salary
        double minimumSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0.0);

        System.out.println("Minimum Salary: " + minimumSalary);

        // 7. Count total employees
        long employeeCount = employees.stream()
                .count();

        System.out.println("Total Employees: " + employeeCount);
    }
}
