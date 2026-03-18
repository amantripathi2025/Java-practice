package Intermediate;

abstract class Appliances{
    String Brand;
    Appliances(String Brand){
        this.Brand = Brand;
    }
    void powerOn(){
        System.out.println("Power is On");
    }
    abstract void operate();

}

class WashingMachine extends Appliances{
    WashingMachine(String Brand){
        super(Brand);
    }
    @Override
    void operate() {
        System.out.println(Brand + " Washing Machine start spinning");
    }
}

class MicroWave extends Appliances{
    MicroWave(String Brand){
        super(Brand);
    }
    @Override
    void operate(){
        System.out.println("Microwave start heating");
    }
}

public class Q13 {
    static void main() {
        Appliances[] appliances = {
                new WashingMachine("Whirlpool"),
                new MicroWave("Lg")
        } ;
        for(Appliances a: appliances){
           a.powerOn();
           a.operate();
            System.out.println("-------------------------------------");


        }
    }
}
