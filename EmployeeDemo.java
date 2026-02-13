import java.util.Scanner;
class Employee {
    private int id;
    private String name;
    private double salary;
    Employee(int empid, String empname, double empsalary) {
        id = empid;
        name = empname;
        salary = empsalary;
    }
    void raiseSalary(double percent) {
        salary = salary + (salary * percent / 100);
    }
    void display() {
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary        : " + salary);
    }
}
public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        Employee emp = new Employee(id, name, salary);
        System.out.println("\nEmployee Details Before Salary Raise:");
        emp.display();
        System.out.print("\nEnter percentage to raise salary: ");
        double percent = sc.nextDouble();
        emp.raiseSalary(percent);
        System.out.println("\nEmployee Details After Salary Raise:");
        emp.display();
        sc.close();
    }
}

