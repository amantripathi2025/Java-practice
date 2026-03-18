package SurpriseTest;

class Employee{
    String name;
    double salary;
    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    void show(){
        System.out.println(name+" ," +salary+ " ");
    }
    double bonus(){
        double bonus = 0.5;
        return salary*bonus;
    }
}

class Manager extends Employee{
    Manager(String name, double salary){
        super(name,salary);
    }
    @Override
    double bonus(){
        double bonus = 0.10;
        return salary*bonus;
    }
}

class Developer extends Employee{
    Developer(String name, double salary){
        super(name,salary);
    }
    double bonus(){
        double bonus = 0.25;
        return salary*bonus;
    }
}



public class TestEmployee {
    static void main() {
        Employee e = new Manager("Aman",80000);
        e.show();
        System.out.println("Bonus is: "+e.bonus());
        System.out.println("Bonus is: "+(e.salary+e.bonus()));

        Employee e1 = new Developer("Devesh",50000);
        e1.show();
        System.out.println("Bonus is: "+e1.bonus());
        System.out.println("Salary after bonus is: "+(e1.salary+e1.bonus()));
    }
}
