package Intermediate;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

class BankAccount{
    String accountHolder;
    double amount;

    BankAccount(String accountHolder,double amount){
        this.accountHolder = accountHolder;
        this.amount = amount;
    }
    void getDetails(){
        System.out.println("Account holder name is: "+accountHolder);
        System.out.println("Total balance: "+amount);
    }
}

class SavingAccount extends BankAccount{
    double interestRate;

    SavingAccount(String accountHolder, double amount, double interestRate){
        this.interestRate = interestRate;
        super(accountHolder, amount);
    }

    @Override
    public void getDetails(){
        System.out.println("--------------------------");
        System.out.println("Type: Saving Account");
        System.out.println("Interest Rate: "+interestRate+"%");
    }
}

class CurrentAccount extends BankAccount{

        double overdraftLimit;

        CurrentAccount(String accountHolder, double amount, double overdraftLimit) {
            super(accountHolder, amount);
            this.overdraftLimit = overdraftLimit;
        }

        @Override
        void getDetails() {
            super.getDetails();
            System.out.println("----------------------------");
            System.out.println("Type: Current Account");
            System.out.println("Overdraft Limit: " + overdraftLimit);
        }
    }


    public class Q16 {
        static void main() {
            BankAccount[] accounts = {
                    new SavingAccount("Rahul", 50000, 4.5),
                    new CurrentAccount("Priya", 100000, 20000)
            };

            for (BankAccount acc : accounts) {
                acc.getDetails();
                System.out.println("----------------------------------------");
            }
        }
}
