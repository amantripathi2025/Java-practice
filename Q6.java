package Basic;

class Bike{
    static class Engine{
        void start(){
            System.out.println("Engine start");
        }

        void stop(){
            System.out.println("Engine stop");
        }
    }

}


public class Q6 {
    static void main() {

        Bike.Engine engine = new Bike.Engine();
        engine.start();
        engine.stop();
    }
}
