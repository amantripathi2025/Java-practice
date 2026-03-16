package Intermediate;

interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

class duck implements Flyable, Swimmable{
    String name;
    duck(String name){
        this.name =name;
    }


    @Override
    public void fly() {
        System.out.println(name+" has the ability to fly");
    }

    @Override
    public void swim() {
        System.out.println(name+" has the ability to swim");
    }
}


public class Q11 {
    static void main() {
        duck d = new duck("Devesh");

        Flyable f = d;
        Swimmable s = d;

        f.fly();
        s.swim();

        d.fly();
        d.swim();

    }
}
