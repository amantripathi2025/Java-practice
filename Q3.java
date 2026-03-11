abstract class Shape{
    abstract double area();
}
class Rectangle extends Shape{
    double length, width;
    Rectangle(double l, double w){
        length = l;
        width = w;
    }

    @Override
    double area() {
       return length * width;

    }
}

class Triangle extends Shape{
    double base, height;
    Triangle(double b, double h){
        base = b;
        height =h;
    }
    @Override
    double area(){
        return 0.5*base*height;
    }
}


public class Q3 {
    static void main() {
       Rectangle R = new Rectangle(3,4);
       R.area();
        System.out.println("Area of the rectangle is: "+R.area());

       Triangle t = new Triangle(4,6);
       t.area();
        System.out.println("Area of the triangle is: "+t.area());
    }
}
