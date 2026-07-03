import java.util.Scanner;
public class TransportCompany {
    public static void main(String[]args){
        String name[] = new String[5];
        int[] ticketCharge = new int[5];
        int weight[] = new int[5];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name and weight luggage of 5 Customers: ");
        for(int i = 0; i < 5; i ++){
            name[i] = input.next();
            weight[i] = input.nextInt();
        }
        double amount = 0.0;
        
        System.out.println("\nSrNo\tName\tWeight\tTicket");
        for(int i = 0; i < 5; i++){
            if(weight[i] <= 10){
               amount = weight[i] * 30;
            }
            else if(weight[i] <= 30){
                amount = (10 * 30) + (weight[i] - 10) * 20;
            }
            else if(weight[i] <= 50){
                amount = (10 * 30) + (20 * 20) + (weight[i] - 30) * 10;
            }
            else{
                amount = (10 * 30) + (20 * 20) + (20 * 10) + ((weight[i] - 50) * 5);
            }
            System.out.println((i + 1) + "\t" + name[i] + "\t" + weight[i] + "\t" + amount);
        }
    }
}
