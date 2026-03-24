/* package Hard;
//Build a Payment System: Abstract class Payment with abstract method cInterfaces Refundable and Taxable Classes CreditCard (implements Refundable + Taxable), UPI (only Taxable), Cash (neither) Use polymorphism to process a list of payments and apply refund/tax where applicable

interface Refundable{
    void refund(double amount);
}

interface Taxable{
    double applyTax(double amount);
}

abstract class Payment{
    String id;
    Payment(String id){
        this.id = id;

        abstract void processPayment(double amount);

    }


}

public class Q15 {
}

 */
