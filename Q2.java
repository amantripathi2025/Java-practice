class Vehicle{
    String brand;
    int speed;

    public Vehicle(int speed, String brand) {
        this.speed = speed;
        this.brand = brand;
    }
    void info(){
        System.out.println("Brand: " +brand+ " Speed: " +speed);
    }
}

class Car extends Vehicle{
    Car(String brand, int speed){
        super( speed, brand);
    }
    void honk(){
        System.out.println(brand+" Car sounds: PEEEEEEEE");
    }
}



public class Q2 {
    static void main() {
        Car c = new Car("Mercedes", 200);
        c.info();
        c.honk();
    }
}
