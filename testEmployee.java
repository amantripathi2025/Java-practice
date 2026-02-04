package in.kgcoding.challange79;

public class testEmployee {
    public static void main(String[] args){
        Employee emp = new Employee("Aman", 18, 125000);
        System.out.println(emp.getEmployeeDetails());
        emp.setName("Divyanshu");
        System.out.println(emp.getEmployeeDetails());
    }
}
