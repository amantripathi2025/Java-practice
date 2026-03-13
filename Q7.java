package Basic;

class Car1{

    String brand = "Porsche";
    class Seat{
        void info(){
            System.out.println("The seat of this car belong to: "+brand);
        }
    }
}


public class Q7 {
    static void main() {


        Car1 car = new Car1();
        Car1.Seat seat = car.new Seat();
        seat.info();
    }
}
