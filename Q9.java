package Intermediate;

class Person{
    String name;
    Person(String name){
        this.name = name;
    }

    void introduce(){
        System.out.println("Hello I'm: "+name);
    }
}

class Student extends Person{
    String course;
    Student(String course, String name){
        super(name);
        this.course = course;
    }

    @Override
    void introduce(){
        super.introduce();
        System.out.println("And my course is: " +course);
    }
}


public class Q9 {
    static void main() {
        Student s = new Student("Computer Science and Engineering","Aman");
        s.introduce();
    }
}
