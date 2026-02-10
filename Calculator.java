package in.kgcoding.challange77.Utils;

import in.kgcoding.challange77.Geometry.Circle;
import in.kgcoding.challange77.Geometry.Rectangle;

public class Calculator {
    public static void main(String[]args){
        Circle cir = new Circle(5.5);
        Rectangle rect = new Rectangle(5,4);

        double cirArea = Math.PI * Math.pow(cir.radius,2);
        double rectArea = rect.length * rect.breadth;

        System.out.printf("Area of circle is %f\nArea of rectangle is %f" ,cirArea, rectArea);
    }

}
