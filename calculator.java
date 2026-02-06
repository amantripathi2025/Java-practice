package in.kgcoding.challange85;

public class calculator {

    public int add(int first, int second){
        return first + second;
    }

    public int add(int first, int second, int third){
        return first + second + third;
    }

    public double add(double first, double second){
        return first + second;
    }

    public static void main(String[]args) {
        calculator calc = new calculator();
        System.out.println(calc.add(5,6));
        System.out.println(calc.add(7,8,9));
        System.out.println(calc.add(5.9,6.2));
    }
}
