package in.kgcoding.challange78;

public class BankAccount {
    private String AccountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName) {
        AccountNumber = accountNumber;
        accountHolderName = accountHolderName;
    }

    public void depositMoney(double money){
        if(money<=0){
            System.out.println("Invalid deposit");
        }
        balance += money;
    }

    public double withdrawMoney(double money){
         if(money <= money){
             System.out.println("Invalid withdrawl");
         }
        else if(money >= 0){
             balance -= money;
         }
        else{
            money = balance;
            balance = 0;
         }
        return money;
    }

}
