package in.kgcoding;

import java.util.Scanner;

class Circle {
     double radiusInMm;
     Circle(double radiusInMm){
         this.radiusInMm = radiusInMm;
     }
     double getCircumfrence(){
         return 2 * radiusInMm * Math.PI;
     }

     double getArea(){
         return Math.PI * Math.pow(radiusInMm,2);
     }

     @Override
     public String toString() {
         return "Circle Props: Radius in mm:"+radiusInMm
         +" ,Circumfrence in mm: "+getCircumfrence()
         +", Area in mm: "+getArea() ;
     }

     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         System.out.println("Welcome to the world of circle\n");

         System.out.println("Enter your radius: ");
         double radius = input.nextDouble();
         Circle circle = new Circle(radius);
         System.out.println(circle);

     }
}
