class Student {
    private String name;
    private int rollNo;
    private double marks;

    Student() {
    }

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String calculateGrade() {
        return "Grade not calculated";
    }
}

public class CollegeStudent extends Student {

    public CollegeStudent(String name, int rollNo, double marks) {
        super(name, rollNo, marks);
    }

    @Override
    public String calculateGrade() {
        double marks = getMarks();

        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "Fails";
    }

    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("RollNo: " + getRollNo());
        System.out.println("Marks: " + getMarks());
        System.out.println("Grade: " + calculateGrade());
        System.out.println();
    }

    public static void main(String[] args) {

        CollegeStudent student1 =
            new CollegeStudent("Rahul", 101, 86.0);

        CollegeStudent student2 =
            new CollegeStudent("Swathi", 105, 97);

        CollegeStudent student3 =
            new CollegeStudent("Ram", 103, 85);

        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
    }
}
