package Intermediate;

class Employee{
    String Name;
    Employee(String Name){
        this.Name = Name;
    }
    String getrole(){
        return "Employee";
    }

    void display(){
        System.out.println(Name+ " is a "+getrole());
    }
}

class Manager extends Employee{
    Manager(String Name){
        super(Name);
    }

    @Override
    String getrole(){
        return "Manager";
    }

}

class Director extends Employee{
    Director(String Name){
        super(Name);
    }

    @Override
    String getrole(){
        return "Director";
    }

}



public class Q8 {
    static void main() {
        Employee[] staff = {
                new Employee("Alok"),
                new Manager("Priti"),
                new Director("Aman")
        };

        for (Employee e : staff) {
            e.display(); // getRole() resolved at runtime
        }
    }
}
