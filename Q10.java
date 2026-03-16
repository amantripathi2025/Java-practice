package Intermediate;

class Shop{
    void processOrder(){
        String itemName = "Laptop";
        int quantity = 4;
        double price = 50000.0;


        class Order{
            void printDetails(){
                System.out.println("Product is:  "+itemName);
                System.out.println("Quantity is: "+quantity);
                System.out.println("Total Price is: "+(quantity*price));
            }
        }

        Order order = new Order();
        order.printDetails();
    }
}



public class Q10 {
    static void main() {
        new Shop().processOrder();
    }
}
